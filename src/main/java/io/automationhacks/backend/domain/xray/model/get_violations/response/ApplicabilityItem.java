package io.automationhacks.backend.domain.xray.model.get_violations.response;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ApplicabilityItem {

    @SerializedName("source_comp_id")
    private String sourceCompId;

    @SerializedName("component_id")
    private String componentId;

    @SerializedName("scan_status")
    private int scanStatus;

    @SerializedName("evidence")
    private Object evidence;

    @SerializedName("cve_id")
    private String cveId;

    @SerializedName("applicability")
    private boolean applicability;

    @SerializedName("scanner_explanation")
    private String scannerExplanation;

    @SerializedName("details")
    private Object details;

    @SerializedName("scanner_available")
    private boolean scannerAvailable;

    @SerializedName("info")
    private String info;

    public String getSourceCompId() {
        return sourceCompId;
    }

    public String getComponentId() {
        return componentId;
    }

    public int getScanStatus() {
        return scanStatus;
    }

    public Object getEvidence() {
        return evidence;
    }

    public String getCveId() {
        return cveId;
    }

    public boolean isApplicability() {
        return applicability;
    }

    public String getScannerExplanation() {
        return scannerExplanation;
    }

    public Object getDetails() {
        return details;
    }

    public boolean isScannerAvailable() {
        return scannerAvailable;
    }

    public String getInfo() {
        return info;
    }
}
