package io.automationhacks.backend.domain.xray.model.create_watch;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

import java.util.List;

@Data
public class ResourcesItem {

    @SerializedName("name")
    private String name;

    @SerializedName("bin_mgr_id")
    private String binMgrId;

    @SerializedName("filters")
    private List<FiltersItem> filters;

    @SerializedName("type")
    private String type;
}
