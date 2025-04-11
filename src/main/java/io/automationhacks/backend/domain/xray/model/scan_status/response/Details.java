package io.automationhacks.backend.domain.xray.model.scan_status.response;

import com.google.gson.annotations.SerializedName;

public class Details{

	@SerializedName("sca")
	private Sca sca;

	@SerializedName("contextual_analysis")
	private ContextualAnalysis contextualAnalysis;

	@SerializedName("exposures")
	private Exposures exposures;

	@SerializedName("violations")
	private Violations violations;
}