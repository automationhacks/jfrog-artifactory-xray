package io.automationhacks.backend.domain.artifactory.client.repositories;

import static io.restassured.RestAssured.given;

import io.automationhacks.backend.core.api.APIResponse;
import io.automationhacks.backend.core.constants.Auth;
import io.automationhacks.backend.domain.artifactory.constants.Endpoints;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;

public class RepositoryClient {
    public APIResponse createRepository(String repoKey, String body) {
        String url = Endpoints.CREATE_REPOSITORY_URL.formatted(Endpoints.BASE_URL);

        RequestSpecification requestSpecification = getRequestSpecification();

        var response =
                given().spec(requestSpecification)
                        .pathParam("repoKey", repoKey)
                        .body(body)
                        .when()
                        .put(url);

        var responseHeaders =
                response.headers().asList().stream()
                        .collect(
                                java.util.stream.Collectors.toMap(
                                        Header::getName, Header::getValue));
        return APIResponse.builder()
                .statusCode(response.getStatusCode())
                .body(response.getBody().asString())
                .headers(responseHeaders)
                .build();
    }

    public APIResponse getRepositories() {
        String url = Endpoints.GET_REPOSITORIES_URL.formatted(Endpoints.BASE_URL);

        var requestSpec = getRequestSpecification();
        var response = given().spec(requestSpec).when().get(url);

        return APIResponse.builder()
                .statusCode(response.getStatusCode())
                .body(response.getBody().asString())
                .build();
    }

    private static RequestSpecification getRequestSpecification() {
        var auth = new Auth().getCredentials();
        return given().auth()
                .basic(auth.username(), auth.password())
                .header("Content-Type", "application/json");
    }
}
