package com.targetindia.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtil {
    private DateUtil() {
    }

    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static Date toDate(String input) {
        try {
            return sdf.parse(input);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String toString(Date input) {
        return sdf.format(input);
    }
}
