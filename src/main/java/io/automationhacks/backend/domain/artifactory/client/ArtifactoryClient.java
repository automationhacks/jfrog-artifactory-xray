package io.automationhacks.backend.domain.artifactory.client;

import static io.automationhacks.backend.core.api.ReqResBuilder.buildAPIResponse;
import static io.automationhacks.backend.core.api.ReqResBuilder.getRequestSpecification;
import static io.restassured.RestAssured.given;

import io.automationhacks.backend.core.api.APIResponse;
import io.automationhacks.backend.domain.artifactory.constants.Endpoints;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArtifactoryClient {
    private final Logger logger = LoggerFactory.getLogger(ArtifactoryClient.class);

    public APIResponse createRepository(String repoKey, String body) {
        String url = Endpoints.CREATE_REPOSITORY_URL.formatted(Endpoints.HOST_NAME);
        logger.info("[REQUEST] Create repository: {}", body);

        var requestSpec = getRequestSpecification();
        var response =
                given().spec(requestSpec).pathParam("repoKey", repoKey).body(body).when().put(url);
        logger.info("[RESPONSE] Create repository: {}", response.getBody().asString());

        return buildAPIResponse(response);
    }

    public APIResponse getRepositories() {
        String url = Endpoints.GET_REPOSITORIES_URL.formatted(Endpoints.HOST_NAME);

        var requestSpec = getRequestSpecification();
        var response = given().spec(requestSpec).when().get(url);
        logger.info("[RESPONSE] Get repositories: {}", response.getBody().asString());

        return buildAPIResponse(response);
    }
}
