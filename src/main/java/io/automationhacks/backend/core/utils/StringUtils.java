package io.automationhacks.backend.core.utils;

public class StringUtils {

    public static String getRandomString() {
        var uuid = java.util.UUID.randomUUID();
        return uuid.toString().substring(0, 5);
    }
}
