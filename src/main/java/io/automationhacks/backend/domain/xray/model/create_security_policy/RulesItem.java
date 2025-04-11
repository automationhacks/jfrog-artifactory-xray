package io.automationhacks.backend.domain.xray.model.create_security_policy;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class RulesItem {

    @SerializedName("criteria")
    private Criteria criteria;

    @SerializedName("name")
    private String name;

    @SerializedName("priority")
    private int priority;

    @SerializedName("actions")
    private Actions actions;
}
