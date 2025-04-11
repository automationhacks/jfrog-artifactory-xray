package io.automationhacks.backend.domain.xray.model.create_security_policy;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

import java.util.List;

@Data
public class CreateSecurityPolicyRequest {

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("rules")
    private List<RulesItem> rules;

    @SerializedName("type")
    private String type;
}
