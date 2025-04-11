package io.automationhacks.backend.domain.artifactory.constants;

public class Endpoints {
    public static final String HOST_NAME = "https://automationhacks.jfrog.io";
    public static final String CREATE_REPOSITORY_URL = "%s/artifactory/api/repositories/{repoKey}";
    public static final String GET_REPOSITORIES_URL = "%s/artifactory/api/repositories";
    public static final String CREATE_SECURITY_POLICY_URL = "%s/xray/api/v2/policies";
}
