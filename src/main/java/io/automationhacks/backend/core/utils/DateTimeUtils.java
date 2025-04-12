package io.automationhacks.backend.core.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    public static String getDateTime(int days, String format) {
        var dateTime = LocalDateTime.now().plusDays(days);
        var formatter = DateTimeFormatter.ofPattern(format);

        return dateTime.format(formatter);
    }
}
