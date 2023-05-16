package com.targetindia.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtil {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private DateUtil() {
    }

    public static String toString(Date dt){
        return sdf.format(dt);
    }
    public static Date toDate(String dt)  {
        try {
            return sdf.parse(dt);
        } catch (ParseException e) {
            return null;
        }
    }
}
