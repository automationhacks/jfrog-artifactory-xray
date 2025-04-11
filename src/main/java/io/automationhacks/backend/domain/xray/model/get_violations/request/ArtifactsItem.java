package io.automationhacks.backend.domain.xray.model.get_violations.request;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArtifactsItem {

    @SerializedName("path")
    private String path;

    @SerializedName("repo")
    private String repo;
}
