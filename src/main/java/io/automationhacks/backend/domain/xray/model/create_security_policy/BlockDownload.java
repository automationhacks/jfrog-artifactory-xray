package io.automationhacks.backend.domain.xray.model.create_security_policy;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class BlockDownload {

    @SerializedName("active")
    private boolean active;

    @SerializedName("unscanned")
    private boolean unscanned;
}
