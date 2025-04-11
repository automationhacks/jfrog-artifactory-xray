package backend.e2e.assertion;

import static com.google.common.truth.Truth.assertWithMessage;

import io.automationhacks.backend.core.api.APIResponse;

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
}
