package io.automationhacks.backend.domain.xray.model.get_violations.request;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class GetViolationsRequest {

    @SerializedName("pagination")
    private Pagination pagination;

    @SerializedName("filters")
    private Filters filters;
}
