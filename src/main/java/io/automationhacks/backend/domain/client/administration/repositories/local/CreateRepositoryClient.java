package io.automationhacks.backend.domain.client.administration.repositories.local;

import static io.restassured.RestAssured.given;

import io.automationhacks.backend.core.api.APIResponse;
import io.automationhacks.backend.core.api.http.HttpMethod;
import io.automationhacks.backend.core.constants.Auth;
import io.automationhacks.backend.domain.constants.Endpoints;

public class CreateRepositoryClient {
    public APIResponse createRepository(String repoKey, String body) {
        String url = Endpoints.CREATE_REPOSITORY_URL.formatted(Endpoints.BASE_URL);

        var auth = new Auth().getCredentials();
        var response =
                given().auth()
                        .basic(auth.username(), auth.password())
                        .pathParam("repoKey", repoKey)
                        .when()
                        .request(HttpMethod.PUT.toString(), url, body);

        return APIResponse.builder()
                .statusCode(response.getStatusCode())
                .body(response.getBody().asString())
                .build();
    }
}
