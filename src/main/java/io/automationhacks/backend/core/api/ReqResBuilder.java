package io.automationhacks.backend.core.api;

import static io.restassured.RestAssured.given;

import io.automationhacks.backend.core.constants.Auth;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReqResBuilder {
    public static RequestSpecification getRequestSpecWithAuthHeader() {
        var auth = new Auth().getCredentials();
        String authHeader =
                "Basic "
                        + java.util.Base64.getEncoder()
                                .encodeToString(
                                        (auth.username() + ":" + auth.password()).getBytes());

        return given().header("Authorization", authHeader)
                .header("Content-Type", "application/json");
    }

    public static RequestSpecification getRequestSpecification() {
        var auth = new Auth().getCredentials();
        return given().auth()
                .basic(auth.username(), auth.password())
                .header("Content-Type", "application/json");
    }

    public static APIResponse buildAPIResponse(Response response) {
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
}
