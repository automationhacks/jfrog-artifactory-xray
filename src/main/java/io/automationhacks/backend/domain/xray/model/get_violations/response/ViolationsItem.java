package io.automationhacks.backend.domain.xray.model.get_violations.response;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class ViolationsItem {

    @SerializedName("severity")
    private String severity;

    @SerializedName("issue_id")
    private String issueId;

    @SerializedName("created")
    private String created;

    @SerializedName("description")
    private String description;

    @SerializedName("impacted_artifacts")
    private List<String> impactedArtifacts;

    @SerializedName("type")
    private String type;

    @SerializedName("extended_information")
    private ExtendedInformation extendedInformation;

    @SerializedName("infected_components")
    private List<String> infectedComponents;

    @SerializedName("watch_name")
    private String watchName;

    @SerializedName("applicability_details")
    private List<ApplicabilityDetailsItem> applicabilityDetails;

    @SerializedName("component_physical_paths")
    private List<String> componentPhysicalPaths;

    @SerializedName("applicability")
    private List<ApplicabilityItem> applicability;

    @SerializedName("violation_details_url")
    private String violationDetailsUrl;

    public String getSeverity() {
        return severity;
    }

    public String getIssueId() {
        return issueId;
    }

    public String getCreated() {
        return created;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getImpactedArtifacts() {
        return impactedArtifacts;
    }

    public String getType() {
        return type;
    }

    public ExtendedInformation getExtendedInformation() {
        return extendedInformation;
    }

    public List<String> getInfectedComponents() {
        return infectedComponents;
    }

    public String getWatchName() {
        return watchName;
    }

    public List<ApplicabilityDetailsItem> getApplicabilityDetails() {
        return applicabilityDetails;
    }

    public List<String> getComponentPhysicalPaths() {
        return componentPhysicalPaths;
    }

    public List<ApplicabilityItem> getApplicability() {
        return applicability;
    }

    public String getViolationDetailsUrl() {
        return violationDetailsUrl;
    }
}
