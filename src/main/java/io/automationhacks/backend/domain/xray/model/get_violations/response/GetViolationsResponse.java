package io.automationhacks.backend.domain.xray.model.get_violations.response;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

import java.util.List;

@Data
public class GetViolationsResponse {

    @SerializedName("total_violations")
    private int totalViolations;

    @SerializedName("violations")
    private List<ViolationsItem> violations;

    public int getTotalViolations() {
        return totalViolations;
    }

    public List<ViolationsItem> getViolations() {
        return violations;
    }
}
