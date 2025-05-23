package io.automationhacks.backend.domain.artifactory.model.repositories;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateRepositoryRequest{
	private String projectKey;
	private String rclass;
	private boolean xrayIndex;
	private String packageType;
	private String key;
}