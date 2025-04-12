package backend.e2e.assertion;

import static com.google.common.truth.Truth.assertWithMessage;

import static io.automationhacks.backend.core.object.Serialization.deserialize;

import io.automationhacks.backend.core.api.APIResponse;
import io.automationhacks.backend.domain.xray.model.scan_status.response.ScanStatusResponse;

public class XrayAssertion {
    public void verifySecurityPolicyIsCreated(APIResponse createSecurityPolicyResponse) {
        assertWithMessage(
                        "Security policy creation failed with status code %s and response %s"
                                .formatted(
                                        createSecurityPolicyResponse.getStatusCode(),
                                        createSecurityPolicyResponse.getBody()))
                .that(createSecurityPolicyResponse.getStatusCode())
                .isEqualTo(201);
    }

    public void verifyWatchIsCreated(APIResponse createWatchResponse) {
        assertWithMessage(
                        "Watch creation failed with status code %s and response %s"
                                .formatted(
                                        createWatchResponse.getStatusCode(),
                                        createWatchResponse.getBody()))
                .that(createWatchResponse.getStatusCode())
                .isEqualTo(201);
    }

    public void verifyXrayScanReturnsSuccess(APIResponse scanStatusResponse, String repoKey) {
        assertWithMessage(
                        "Scan status failed with status code %s and response %s"
                                .formatted(
                                        scanStatusResponse.getStatusCode(),
                                        scanStatusResponse.getBody()))
                .that(scanStatusResponse.getStatusCode())
                .isEqualTo(200);
    }

    public void verifyWatchIsAppliedOnPolicy(APIResponse applyWatchResponse) {
        assertWithMessage(
                        "Apply watch failed with status code %s and response %s"
                                .formatted(
                                        applyWatchResponse.getStatusCode(),
                                        applyWatchResponse.getBody()))
                .that(applyWatchResponse.getStatusCode())
                .isEqualTo(202);
    }

    public void verifyViolationsArePresentAsPerPolicy(APIResponse getViolationsResponse) {
        assertWithMessage(
                        "Get violations failed with status code %s and response %s"
                                .formatted(
                                        getViolationsResponse.getStatusCode(),
                                        getViolationsResponse.getBody()))
                .that(getViolationsResponse.getStatusCode())
                .isEqualTo(200);
    }
}
