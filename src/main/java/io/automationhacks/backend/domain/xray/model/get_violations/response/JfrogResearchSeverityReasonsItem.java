package io.automationhacks.backend.domain.xray.model.get_violations.response;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class JfrogResearchSeverityReasonsItem {

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("is_positive")
    private boolean isPositive;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isIsPositive() {
        return isPositive;
    }
}
