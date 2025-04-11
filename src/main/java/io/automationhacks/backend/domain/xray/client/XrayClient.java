package io.automationhacks.backend.domain.xray.client;

import static io.restassured.RestAssured.given;

import io.automationhacks.backend.core.api.APIResponse;
import io.automationhacks.backend.core.constants.Auth;
import io.automationhacks.backend.domain.artifactory.constants.Endpoints;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;

public class XrayClient {

    public APIResponse createSecurityPolicy(String body) {
        String url = Endpoints.CREATE_SECURITY_POLICY_URL.formatted(Endpoints.HOST_NAME);

        var requestSpecification = getRequestSpecification();

        var response = given().spec(requestSpecification).body(body).when().post(url);

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

    public APIResponse createWatch(String body) {
        String url = Endpoints.CREATE_WATCH_URL.formatted(Endpoints.HOST_NAME);

        var requestSpecification = getRequestSpecification();

        var response = given().spec(requestSpecification).body(body).when().post(url);

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

    public APIResponse applyWatch(String body) {
        String url = Endpoints.APPLY_WATCH_URL.formatted(Endpoints.HOST_NAME);

        var requestSpecification = getRequestSpecification();

        var response = given().spec(requestSpecification).when().body(body).post(url);

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

    private static RequestSpecification getRequestSpecification() {
        var auth = new Auth().getCredentials();
        String authHeader =
                "Basic "
                        + java.util.Base64.getEncoder()
                                .encodeToString(
                                        (auth.username() + ":" + auth.password()).getBytes());

        return given().header("Authorization", authHeader)
                .header("Content-Type", "application/json");
    }
}
