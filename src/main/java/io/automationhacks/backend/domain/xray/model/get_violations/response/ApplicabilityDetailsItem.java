package io.automationhacks.backend.domain.xray.model.get_violations.response;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class ApplicabilityDetailsItem {

    @SerializedName("result")
    private String result;

    @SerializedName("source_comp_id")
    private String sourceCompId;

    @SerializedName("component_id")
    private String componentId;

    @SerializedName("vulnerability_id")
    private String vulnerabilityId;

    public String getResult() {
        return result;
    }

    public String getSourceCompId() {
        return sourceCompId;
    }

    public String getComponentId() {
        return componentId;
    }

    public String getVulnerabilityId() {
        return vulnerabilityId;
    }
}
