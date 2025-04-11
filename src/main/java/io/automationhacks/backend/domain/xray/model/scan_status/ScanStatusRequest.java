package io.automationhacks.backend.domain.xray.model.scan_status;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScanStatusRequest {

    @SerializedName("path")
    private String path;

    @SerializedName("repo")
    private String repo;
}
