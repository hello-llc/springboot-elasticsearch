package com.cun.util.es.utils;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommUtils {
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static InetAddress addr;

    public CommUtils() {
    }

    public static InetAddress getLocalAddress() {
        if (addr == null) {
            try {
                addr = InetAddress.getLocalHost();
            } catch (UnknownHostException var1) {
                var1.printStackTrace();
            }
        }

        return addr;
    }

    public static String formatDate() {
        DateFormat sf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return sf.format(new Date());
    }
}