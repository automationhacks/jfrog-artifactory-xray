package io.automationhacks.backend.domain.xray.model.apply_watch;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class DateRange {

    @SerializedName("end_date")
    private String endDate;

    @SerializedName("start_date")
    private String startDate;
}
