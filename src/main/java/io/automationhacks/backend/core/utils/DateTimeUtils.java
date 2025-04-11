package io.automationhacks.backend.core.utils;

public class DateTimeUtils {

    // write a function that can generate a date in format 2025-04-09T10:25:00+02:00 and x days from
    // today in the pas
    public static String getDateTime(int days, String format) {
        java.time.LocalDateTime dateTime = java.time.LocalDateTime.now().plusDays(days);
        java.time.format.DateTimeFormatter formatter =
                java.time.format.DateTimeFormatter.ofPattern(format);
        return dateTime.format(formatter);
    }
}
