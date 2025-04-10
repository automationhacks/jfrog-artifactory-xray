package io.automationhacks.backend.domain.artifactory.model.repositories.get_repositories;

import lombok.Data;

@Data
public class GetRepositoriesResponseItem {
    private String description;
    private String type;
    private String packageType;
    private String key;
    private String url;
}
