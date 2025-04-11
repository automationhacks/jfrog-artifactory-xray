package io.automationhacks.backend.domain.xray.model.create_watch;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class GeneralData {

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("active")
    private boolean active;
}
