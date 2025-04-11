package io.automationhacks.backend.domain.xray.model.get_violations.request;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Pagination {

    @SerializedName("offset")
    private int offset;

    @SerializedName("limit")
    private int limit;

    @SerializedName("order_by")
    private String orderBy;

    @SerializedName("direction")
    private String direction;
}
