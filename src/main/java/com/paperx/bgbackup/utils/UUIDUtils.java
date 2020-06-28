package com.paperx.bgbackup.utils;

import java.util.UUID;

public class UUIDUtils {
    public static String uuid() {
        //生成uuid
        UUID uuid = UUID.randomUUID();
        String uuidStr;
        uuidStr = uuid.toString().replaceAll("-", "");
        return uuidStr;
    }
}
