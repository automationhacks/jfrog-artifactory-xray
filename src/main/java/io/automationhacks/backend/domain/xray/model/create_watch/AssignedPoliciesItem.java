package io.automationhacks.backend.domain.xray.model.create_watch;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class AssignedPoliciesItem {

    @SerializedName("name")
    private String name;

    @SerializedName("type")
    private String type;
}
