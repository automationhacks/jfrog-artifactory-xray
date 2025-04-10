package io.automationhacks.backend.core.api;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class APIResponse {
    private int statusCode;
    private String body;
    Map<String, String> headers;
}
