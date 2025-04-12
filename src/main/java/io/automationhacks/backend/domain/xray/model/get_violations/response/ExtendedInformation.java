package io.automationhacks.backend.domain.xray.model.get_violations.response;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class ExtendedInformation {

    @SerializedName("short_description")
    private String shortDescription;

    @SerializedName("full_description")
    private String fullDescription;

    @SerializedName("jfrog_research_severity_reasons")
    private List<JfrogResearchSeverityReasonsItem> jfrogResearchSeverityReasons;

    @SerializedName("jfrog_research_severity")
    private String jfrogResearchSeverity;

    @SerializedName("remediation")
    private String remediation;

    public String getShortDescription() {
        return shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public List<JfrogResearchSeverityReasonsItem> getJfrogResearchSeverityReasons() {
        return jfrogResearchSeverityReasons;
    }

    public String getJfrogResearchSeverity() {
        return jfrogResearchSeverity;
    }

    public String getRemediation() {
        return remediation;
    }
}
