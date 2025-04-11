package io.automationhacks.backend.domain.xray.model.create_watch;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

import java.util.List;

@Data
public class ProjectResources {

    @SerializedName("resources")
    private List<ResourcesItem> resources;
}
