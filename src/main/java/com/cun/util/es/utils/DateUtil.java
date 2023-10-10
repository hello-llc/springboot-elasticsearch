package com.cun.util.es.utils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    static String[] possiblePatterns =
            {
                    "yyyy-MM-dd",
                    "yyyy-MM-dd HH:mm:ss",
                    "yyyyMMdd",
                    "yyyy/MM/dd",
                    "yyyy年MM月dd日",
                    "yyyy MM dd"
            };

    public static Date parseDate(String inputDate) {
        SimpleDateFormat df = new SimpleDateFormat();
        for (String pattern : possiblePatterns) {
            df.applyPattern(pattern);
            df.setLenient(false);//设置解析日期格式是否严格解析日期
            ParsePosition pos = new ParsePosition(0);
            Date date = df.parse(inputDate, pos);
            if (date != null) {
                return date;
            }
        }
        return null;
    }
}
