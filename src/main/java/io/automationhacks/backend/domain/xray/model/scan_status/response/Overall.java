package io.automationhacks.backend.domain.xray.model.scan_status.response;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Overall {

    @SerializedName("time")
    private String time;

    @SerializedName("status")
    private String status;
}
