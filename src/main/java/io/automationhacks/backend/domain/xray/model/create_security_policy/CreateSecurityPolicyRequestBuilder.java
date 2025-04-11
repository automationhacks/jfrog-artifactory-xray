package io.automationhacks.backend.domain.xray.model.create_security_policy;

import io.automationhacks.backend.core.file.FileManager;
import io.automationhacks.backend.core.object.Serialization;

public class CreateSecurityPolicyRequestBuilder {
    private final CreateSecurityPolicyRequest createSecurityPolicyRequest;

    public CreateSecurityPolicyRequestBuilder() {
        var body =
                FileManager.readFile(
                        "test_data/xray/create_security_policy/min_severity_as_high.json");
        createSecurityPolicyRequest =
                Serialization.deserialize(body, CreateSecurityPolicyRequest.class);
    }

    public CreateSecurityPolicyRequestBuilder withNameDescription(String name, String description) {
        this.createSecurityPolicyRequest.setName(name);
        this.createSecurityPolicyRequest.setDescription(description);
        return this;
    }

    public CreateSecurityPolicyRequest build() {
        return this.createSecurityPolicyRequest;
    }
}
