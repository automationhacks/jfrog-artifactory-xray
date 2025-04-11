package io.automationhacks.backend.domain.xray.model.create_watch;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class FiltersItem {

    @SerializedName("type")
    private String type;

    @SerializedName("value")
    private String value;
}
