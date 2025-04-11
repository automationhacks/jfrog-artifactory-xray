package io.automationhacks.backend.domain.xray.model.scan_status.response;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class ScanStatusResponse {

    @SerializedName("overall")
    private Overall overall;

    @SerializedName("details")
    private Details details;
}
