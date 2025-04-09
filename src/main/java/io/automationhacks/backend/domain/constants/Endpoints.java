package io.automationhacks.backend.domain.constants;

public class Endpoints {
    public static final String BASE_URL = "https://automationhacks.jfrog.io";
    public static final String ARTIFACTORY_URL = BASE_URL + "/artifactory";
    public static final String REPOSITORY_URL = ARTIFACTORY_URL + "/api/repositories";
    public static final String CREATE_REPOSITORY_URL = "%s/artifactory/api/repositories/{repoKey}";


}
