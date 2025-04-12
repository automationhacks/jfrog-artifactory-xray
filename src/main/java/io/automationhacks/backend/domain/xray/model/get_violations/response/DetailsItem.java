package io.automationhacks.backend.domain.xray.model.get_violations.response;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class DetailsItem {

    @SerializedName("file_path")
    private String filePath;

    @SerializedName("details")
    private String details;

    public String getFilePath() {
        return filePath;
    }

    public String getDetails() {
        return details;
    }
}
