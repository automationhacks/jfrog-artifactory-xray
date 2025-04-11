package io.automationhacks.backend.domain.xray.model.scan_status.response;

import com.google.gson.annotations.SerializedName;

public class Categories{

	@SerializedName("iac")
	private Iac iac;

	@SerializedName("services")
	private Services services;

	@SerializedName("secrets")
	private Secrets secrets;

	@SerializedName("applications")
	private Applications applications;
}