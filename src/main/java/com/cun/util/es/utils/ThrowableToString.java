package com.cun.util.es.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ThrowableToString {

    public static String errorInfoToString(Throwable e) {
        //try-with-resource语法糖 处理机制
        try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
            return sw.toString();
        } catch (Exception ignored) {
            return e.getMessage();
        }
    }

}
