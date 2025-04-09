package io.automationhacks.backend.core.utils;

public class StringUtils {
    public static int getRandomNumberBetweenRange(int start, int end) {
        if (start >= end) {
            throw new IllegalArgumentException("Start must be less than end");
        }
        return (int) (Math.random() * (end - start)) + start;
    }
}
