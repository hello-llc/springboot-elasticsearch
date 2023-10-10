package com.cun.util.es.utils;

import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import java.util.Objects;


public class LoggerUtilFactory {

    private static Logger loggerUtil;

    @PostConstruct
    public static Logger getLoggerUtil() {
        if (Objects.equals(null, LoggerUtilFactory.loggerUtil)) {
            LoggerUtilFactory.loggerUtil = SpringUtil.getBean(LoggerUtilImpl.class);
        }

        return loggerUtil;
    }

}
