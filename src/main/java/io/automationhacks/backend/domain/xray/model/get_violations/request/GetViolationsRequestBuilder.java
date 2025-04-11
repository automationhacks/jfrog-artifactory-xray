package io.automationhacks.backend.domain.xray.model.get_violations.request;

import io.automationhacks.backend.core.file.FileManager;
import io.automationhacks.backend.core.object.Serialization;

import java.util.List;

public class GetViolationsRequestBuilder {
    private final GetViolationsRequest getViolationsRequest;

    public GetViolationsRequestBuilder() {
        var body =
                FileManager.readFile("test_data/xray/get_violations/get_violations_request.json");
        getViolationsRequest = Serialization.deserialize(body, GetViolationsRequest.class);
    }

    public GetViolationsRequestBuilder withWatchName(String watchName) {
        this.getViolationsRequest.getFilters().setWatchName(watchName);
        return this;
    }

    public GetViolationsRequestBuilder withArtifact(ArtifactsItem artifact) {
        this.getViolationsRequest.getFilters().getResources().setArtifacts(List.of(artifact));
        return this;
    }

    public GetViolationsRequest build() {
        return this.getViolationsRequest;
    }
}
