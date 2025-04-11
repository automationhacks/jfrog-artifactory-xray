package io.automationhacks.backend.domain.xray.model.get_violations.request;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

import java.util.List;

@Data
public class Resources {

    @SerializedName("artifacts")
    private List<ArtifactsItem> artifacts;
}
