package io.automationhacks.backend.domain.xray.model.scan_status.response;

import com.google.gson.annotations.SerializedName;

public class Sca{

	@SerializedName("time")
	private String time;

	@SerializedName("status")
	private String status;
}