package backend.e2e.tests;

import backend.e2e.flow.ArtifactoryFlow;
import backend.e2e.flow.XrayFlow;
import backend.e2e.helper.APITestHelper;

import io.automationhacks.backend.core.env.Environment;
import io.automationhacks.backend.core.utils.StringUtils;
import io.automationhacks.common.testing.TestSuites;

import org.testng.annotations.Test;

public class SecurityViolationsPerPolicyAPITest {
    @Test(
            groups = {TestSuites.BACKEND, TestSuites.SMOKE, TestSuites.REGRESSION},
            description =
                    """
                GIVEN repo is uploaded
                WHEN security policy and watch is created
                THEN violations should be as per policy""")
    public void
            givenRepoIsUploaded_WhenSecurityPolicyAndWatchIsCreated_ThenViolationsShouldBeAsPerPolicy() {
        String repoKey = "docker-local-%s".formatted(StringUtils.getRandomString());
        new ArtifactoryFlow().createRepositoryInArtifactory(repoKey);

        var testHelper = new APITestHelper();

        String dockerImage = "alpine:3.9";
        testHelper.pushImageToRepository(
                repoKey, dockerImage, dockerImage, Environment.getHostName());

        String secPolicyName = "%s_policy".formatted(repoKey);
        var xRayFlow = new XrayFlow();
        xRayFlow.createSecurityPolicy(secPolicyName);

        String watchName = "%s_watch".formatted(repoKey);
        xRayFlow.createWatch(repoKey, watchName, secPolicyName);
        xRayFlow.applyWatchOnPolicy(watchName, -5, 5);

        String artifactPath = "alpine/3.9/manifest.json";
        xRayFlow.checkScanIsDone(repoKey, artifactPath);
        xRayFlow.checkViolationsAreGenerated(repoKey, artifactPath, watchName);
    }
}
