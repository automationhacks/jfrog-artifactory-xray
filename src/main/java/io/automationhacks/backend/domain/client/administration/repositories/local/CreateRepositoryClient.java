package io.automationhacks.backend.domain.client.administration.repositories.local;

import static io.restassured.RestAssured.given;

import io.automationhacks.backend.core.api.APIResponse;
import io.automationhacks.backend.core.constants.Auth;
import io.automationhacks.backend.domain.constants.Endpoints;
import io.restassured.specification.RequestSpecification;

public class CreateRepositoryClient {
    public APIResponse createRepository(String repoKey, String body) {
        String url = Endpoints.CREATE_REPOSITORY_URL.formatted(Endpoints.BASE_URL);

        var auth = new Auth().getCredentials();
        RequestSpecification requestSpecification =
                given().auth()
                        .basic(auth.username(), auth.password())
                        .header("Content-Type", "application/json");

        var response =
                given().spec(requestSpecification)
                        .pathParam("repoKey", repoKey)
                        .body(body)
                        .when()
                        .put(url);

        return APIResponse.builder()
                .statusCode(response.getStatusCode())
                .body(response.getBody().asString())
                .build();
    }
}
