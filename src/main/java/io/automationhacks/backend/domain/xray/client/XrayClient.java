package io.automationhacks.backend.domain.xray.client;

import static io.automationhacks.backend.core.api.ReqResBuilder.buildAPIResponse;
import static io.automationhacks.backend.core.api.ReqResBuilder.getRequestSpecWithAuthHeader;
import static io.restassured.RestAssured.given;

import io.automationhacks.backend.core.api.APIResponse;
import io.automationhacks.backend.domain.artifactory.constants.Endpoints;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XrayClient {
    private final Logger logger = LoggerFactory.getLogger(XrayClient.class);

    public APIResponse createSecurityPolicy(String body) {
        String url = Endpoints.CREATE_SECURITY_POLICY_URL.formatted(Endpoints.HOST_NAME);
        logger.info("[REQUEST] Create security policy: %s".formatted(body));

        var requestSpec = getRequestSpecWithAuthHeader();
        var response = given().spec(requestSpec).body(body).when().post(url);
        logger.info(
                "[RESPONSE] Create security policy: %s".formatted(response.getBody().asString()));

        return buildAPIResponse(response);
    }

    public APIResponse createWatch(String body) {
        String url = Endpoints.CREATE_WATCH_URL.formatted(Endpoints.HOST_NAME);
        logger.info("[REQUEST] Create watch: %s".formatted(body));

        var requestSpecification = getRequestSpecWithAuthHeader();
        var response = given().spec(requestSpecification).body(body).when().post(url);
        logger.info("[RESPONSE] Create watch: %s".formatted(response.getBody().asString()));

        return buildAPIResponse(response);
    }

    public APIResponse applyWatch(String body) {
        String url = Endpoints.APPLY_WATCH_URL.formatted(Endpoints.HOST_NAME);
        logger.info("[REQUEST] Apply watch: %s".formatted(body));

        var requestSpecification = getRequestSpecWithAuthHeader();
        var response = given().spec(requestSpecification).when().body(body).post(url);
        logger.info("[RESPONSE] Apply watch: %s".formatted(response.getBody().asString()));

        return buildAPIResponse(response);
    }

    public APIResponse getScanStatus(String body) {
        String url = Endpoints.SCAN_STATUS_URL.formatted(Endpoints.HOST_NAME);
        logger.info("[REQUEST] Get scan status: %s".formatted(body));

        var requestSpecification = getRequestSpecWithAuthHeader();
        var response = given().spec(requestSpecification).when().body(body).post(url);
        logger.info("[RESPONSE] Get scan status: %s".formatted(response.getBody().asString()));

        return buildAPIResponse(response);
    }

    public APIResponse getViolations(String body) {
        String url = Endpoints.GET_VIOLATIONS_URL.formatted(Endpoints.HOST_NAME);
        logger.info("[REQUEST] Get violations: %s".formatted(body));

        var requestSpecification = getRequestSpecWithAuthHeader();
        var response = given().spec(requestSpecification).when().body(body).post(url);
        logger.info("[RESPONSE] Get violations: %s".formatted(response.getBody().asString()));

        return buildAPIResponse(response);
    }
}
