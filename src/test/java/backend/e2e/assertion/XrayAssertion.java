package backend.e2e.assertion;

import static com.google.common.truth.Truth.assertWithMessage;

import static io.automationhacks.backend.core.object.Serialization.deserialize;

import io.automationhacks.backend.core.api.APIResponse;
import io.automationhacks.backend.domain.xray.model.get_violations.response.GetViolationsResponse;

import org.awaitility.Awaitility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class XrayAssertion {
    private final Logger logger = LoggerFactory.getLogger(XrayAssertion.class);

    public void verifySecurityPolicyIsCreated(APIResponse createSecurityPolicyResponse) {
        assertWithMessage(
                        "Security policy creation failed with status code %s and response %s"
                                .formatted(
                                        createSecurityPolicyResponse.getStatusCode(),
                                        createSecurityPolicyResponse.getBody()))
                .that(createSecurityPolicyResponse.getStatusCode())
                .isEqualTo(201);
        logger.info("✅ Security policy created successfully");
    }

    public void verifyWatchIsCreated(APIResponse createWatchResponse) {
        assertWithMessage(
                        "Watch creation failed with status code %s and response %s"
                                .formatted(
                                        createWatchResponse.getStatusCode(),
                                        createWatchResponse.getBody()))
                .that(createWatchResponse.getStatusCode())
                .isEqualTo(201);
        logger.info("✅ Watch created successfully");
    }

    public void verifyXrayScanReturnsSuccess(APIResponse scanStatusResponse, String repoKey) {
        assertWithMessage(
                        "Scan status failed with status code %s and response %s"
                                .formatted(
                                        scanStatusResponse.getStatusCode(),
                                        scanStatusResponse.getBody()))
                .that(scanStatusResponse.getStatusCode())
                .isEqualTo(200);
        logger.info("✅ Scan status is successful");
    }

    public void verifyWatchIsAppliedOnPolicy(APIResponse applyWatchResponse) {
        assertWithMessage(
                        "Apply watch failed with status code %s and response %s"
                                .formatted(
                                        applyWatchResponse.getStatusCode(),
                                        applyWatchResponse.getBody()))
                .that(applyWatchResponse.getStatusCode())
                .isEqualTo(202);
        logger.info("✅ Watch applied on policy successfully");
    }

    public void verifyViolationsAreGenerated(APIResponse getViolationsResponse) {
        assertWithMessage(
                        "Get violations failed with status code %s and response %s"
                                .formatted(
                                        getViolationsResponse.getStatusCode(),
                                        getViolationsResponse.getBody()))
                .that(getViolationsResponse.getStatusCode())
                .isEqualTo(200);

        var response = deserialize(getViolationsResponse.getBody(), GetViolationsResponse.class);

        verifyViolationsAreGreaterThanZero(response);
        logger.info("✅ Violations are present as per policy");
    }

    public void verifyViolationsAreGreaterThanZero(GetViolationsResponse response) {
        Awaitility.await()
                .atMost(30, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                assertWithMessage(
                                                "Total violations should be greater than 0, but got %s"
                                                        .formatted(response.getTotalViolations()))
                                        .that(response.getTotalViolations())
                                        .isGreaterThan(0));
    }
}
