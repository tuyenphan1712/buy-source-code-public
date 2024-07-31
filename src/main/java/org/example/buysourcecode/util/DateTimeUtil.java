package org.example.buysourcecode.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    public static Long toEpochSecond(LocalDateTime localDateTime) {
        return localDateTime.toInstant(ZoneOffset.UTC).getEpochSecond();
    }

    public static String toDateString(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        return localDate.format(formatter);
    }

}
