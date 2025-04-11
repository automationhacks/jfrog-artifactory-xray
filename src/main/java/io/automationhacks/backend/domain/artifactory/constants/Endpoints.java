package io.automationhacks.backend.domain.artifactory.constants;

public class Endpoints {
    public static final String HOST_NAME = "https://automationhacks.jfrog.io";
    public static final String CREATE_REPOSITORY_URL = "%s/artifactory/api/repositories/{repoKey}";
    public static final String GET_REPOSITORIES_URL = "%s/artifactory/api/repositories";
    public static final String CREATE_SECURITY_POLICY_URL = "%s/xray/api/v2/policies";
    public static final String CREATE_WATCH_URL = "%s/xray/api/v2/watches";
    public static final String APPLY_WATCH_URL = "%s/xray/api/v1/applyWatch";
    public static final String SCAN_STATUS_URL = "%s/xray/api/v1/artifact/status";
    public static final String GET_VIOLATIONS_URL = "%s/xray/api/v1/violations";
}
