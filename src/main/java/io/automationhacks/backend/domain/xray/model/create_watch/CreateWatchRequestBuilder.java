package io.automationhacks.backend.domain.xray.model.create_watch;

import io.automationhacks.backend.core.file.FileManager;
import io.automationhacks.backend.core.object.Serialization;

public class CreateWatchRequestBuilder {
    private final CreateWatchRequest createWatchRequest;

    public CreateWatchRequestBuilder() {
        var body = FileManager.readFile("test_data/xray/create_watch/create_watch_on_security_policy.json");
        createWatchRequest = Serialization.deserialize(body, CreateWatchRequest.class);
    }

    public CreateWatchRequestBuilder withWatchAndPolicyName(String watchName, String policyName) {
        this.createWatchRequest.getGeneralData().setName(watchName);
        this.createWatchRequest.getAssignedPolicies().get(0).setName(policyName);
        return this;
    }

    public CreateWatchRequest build() {
        return this.createWatchRequest;
    }
}
