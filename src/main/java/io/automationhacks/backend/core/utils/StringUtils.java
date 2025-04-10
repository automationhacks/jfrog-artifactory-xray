package io.automationhacks.backend.core.utils;

public class StringUtils {
    public static int getRandomNumberBetweenRange(int start, int end) {
        if (start >= end) {
            throw new IllegalArgumentException("Start must be less than end");
        }
        return (int) (Math.random() * (end - start)) + start;
    }

    public static String getRandomString() {
        var uuid = java.util.UUID.randomUUID();
        return uuid.toString().substring(0, 5);
    }
}
