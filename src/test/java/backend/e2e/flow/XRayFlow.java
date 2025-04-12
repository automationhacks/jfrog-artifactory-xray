package backend.e2e.flow;

import static io.automationhacks.backend.core.object.Serialization.serialize;

import backend.e2e.assertion.XrayAssertion;

import backend.e2e.helper.TestHelper;
import io.automationhacks.backend.core.constants.DateTimeConstants;
import io.automationhacks.backend.core.utils.DateTimeUtils;
import io.automationhacks.backend.domain.xray.client.XrayClient;
import io.automationhacks.backend.domain.xray.model.apply_watch.ApplyWatchRequestBuilder;
import io.automationhacks.backend.domain.xray.model.create_security_policy.CreateSecurityPolicyRequestBuilder;
import io.automationhacks.backend.domain.xray.model.create_watch.CreateWatchRequestBuilder;
import io.automationhacks.backend.domain.xray.model.get_violations.request.ArtifactsItem;
import io.automationhacks.backend.domain.xray.model.get_violations.request.GetViolationsRequestBuilder;
import io.automationhacks.backend.domain.xray.model.scan_status.ScanStatusRequest;

public class XRayFlow {
    XrayClient xRayClient = new XrayClient();
    XrayAssertion xrayAssertion = new XrayAssertion();
    TestHelper testHelper = new TestHelper();

    public void createSecurityPolicy(String secPolicyName) {
        var createSecurityPolicyRequest =
                new CreateSecurityPolicyRequestBuilder()
                        .withNameDescription(
                                secPolicyName, "Security policy with min severity as high")
                        .build();
        var createSecurityPolicyResponse =
                xRayClient.createSecurityPolicy(serialize(createSecurityPolicyRequest));

        xrayAssertion.verifySecurityPolicyIsCreated(createSecurityPolicyResponse);
    }

    public void createWatch(String repoKey, String watchName, String secPolicyName) {
        var createWatchRequest =
                new CreateWatchRequestBuilder()
                        .withWatchAndPolicyName(watchName, secPolicyName)
                        .withProjectResourcesName(repoKey)
                        .build();
        var createWatchResponse = xRayClient.createWatch(serialize(createWatchRequest));
        xrayAssertion.verifyWatchIsCreated(createWatchResponse);
    }

    public void applyWatchOnPolicy(String watchName, int startDateFromToday, int endDateFromToday) {
        var applyWatchRequest =
                new ApplyWatchRequestBuilder()
                        .withWatchName(watchName)
                        .withDates(
                                DateTimeUtils.getDateTime(
                                        startDateFromToday, DateTimeConstants.DATE_TIME_FORMAT),
                                DateTimeUtils.getDateTime(
                                        endDateFromToday, DateTimeConstants.DATE_TIME_FORMAT))
                        .build();
        var applyWatchResponse = xRayClient.applyWatch(serialize(applyWatchRequest));
        xrayAssertion.verifyWatchIsAppliedOnPolicy(applyWatchResponse);
    }

    public void checkScanIsDone(String repoKey, String artifactPath) {
        var scanStatusRequest =
                ScanStatusRequest.builder().repo(repoKey).path(artifactPath).build();
        String scanStatusRequestStr = serialize(scanStatusRequest);

        var scanStatusResponse = xRayClient.getScanStatus(scanStatusRequestStr);

        testHelper.waitForXRayScanToBeDone(scanStatusRequestStr);
        xrayAssertion.verifyXrayScanReturnsSuccess(scanStatusResponse, repoKey);
    }

    public void checkViolationsAreGenerated(String repoKey, String artifactPath, String watchName) {
        var getViolationsRequest =
                new GetViolationsRequestBuilder()
                        .withWatchName(watchName)
                        .withArtifact(
                                ArtifactsItem.builder().path(artifactPath).repo(repoKey).build())
                        .build();
        var getViolationsResponse = xRayClient.getViolations(serialize(getViolationsRequest));
        xrayAssertion.verifyViolationsAreGenerated(getViolationsResponse);
    }
}
