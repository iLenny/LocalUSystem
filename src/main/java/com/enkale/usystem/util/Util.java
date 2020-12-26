package com.enkale.usystem.util;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
    public static String getCurrentTimeStamp() {
        return ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss z"));
    }
}
