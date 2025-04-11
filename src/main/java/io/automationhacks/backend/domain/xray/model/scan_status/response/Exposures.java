package io.automationhacks.backend.domain.xray.model.scan_status.response;

import com.google.gson.annotations.SerializedName;

public class Exposures{

	@SerializedName("time")
	private String time;

	@SerializedName("categories")
	private Categories categories;

	@SerializedName("status")
	private String status;
}