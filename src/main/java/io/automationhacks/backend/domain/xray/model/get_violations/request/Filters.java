package io.automationhacks.backend.domain.xray.model.get_violations.request;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Filters {

    @SerializedName("watch_name")
    private String watchName;

    @SerializedName("violation_type")
    private String violationType;

    @SerializedName("resources")
    private Resources resources;

    @SerializedName("min_severity")
    private String minSeverity;
}
