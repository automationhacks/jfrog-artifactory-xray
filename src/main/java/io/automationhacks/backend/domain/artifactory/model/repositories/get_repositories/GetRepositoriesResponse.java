package io.automationhacks.backend.domain.artifactory.model.repositories.get_repositories;

import java.util.List;
import lombok.Data;

@Data
public class GetRepositoriesResponse{
	private List<GetRepositoriesResponseItem> getRepositoriesResponse;
}