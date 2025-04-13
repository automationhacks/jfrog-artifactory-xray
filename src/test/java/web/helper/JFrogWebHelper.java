package web.helper;

import static io.automationhacks.backend.core.env.Environment.getPassword;
import static io.automationhacks.backend.core.env.Environment.getUsername;

import backend.e2e.flow.ArtifactoryFlow;
import backend.e2e.flow.XrayFlow;
import backend.e2e.helper.APITestHelper;

import io.automationhacks.backend.core.env.Environment;
import io.automationhacks.web.domain.page_objects.common.LoadingPage;
import io.automationhacks.web.domain.page_objects.login.LoginPage;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JFrogWebHelper {
    private final Logger logger = LoggerFactory.getLogger(JFrogWebHelper.class);

    public void setUpRepoPolicyAndWatches(String repoKey) {
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

    public void loginToJFrog(WebDriver driver) {
        var loadingPage = new LoadingPage(driver);
        loadingPage.waitForAnimationToFinish();

        var loginPage = new LoginPage(driver);
        loginPage.waitForLoginPageToLoad();
        loginPage.login(getUsername(), getPassword());

        loadingPage.waitForAnimationToFinish();
        logger.info("✅ Login to JFrog UI successful");
    }
}
