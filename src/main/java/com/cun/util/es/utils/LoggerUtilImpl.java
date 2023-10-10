package com.cun.util.es.utils;


import com.cun.util.es.module.CurrentMethodParam;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LoggerUtilImpl implements Logger {

    @Autowired
    LoggerUtil loggerUtil;


    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean isTraceEnabled() {
        return false;
    }

    @Override
    public void trace(String msg) {
        CurrentMethodParam currentMethodParam = CurrentMethodInfo.getMethodInfo();
        loggerUtil.trace(currentMethodParam, msg);
    }

    @Override
    public void trace(String format, Object arg) {
        CurrentMethodParam currentMethodParam = CurrentMethodInfo.getMethodInfo();
        String msg = ParserPlaceHolder.parseNormal(format, arg);
        loggerUtil.trace(currentMethodParam, msg);
    }

    @Override
    public void trace(String format, Object arg1, Object arg2) {
        CurrentMethodParam currentMethodParam = CurrentMethodInfo.getMethodInfo();
        String msg = ParserPlaceHolder.parseNormal(format, arg1, arg2);
        loggerUtil.trace(currentMethodParam, msg);
    }

    @Override
    public void trace(String format, Object... arguments) {
        CurrentMethodParam currentMethodParam = CurrentMethodInfo.getMethodInfo();
        String msg = ParserPlaceHolder.parseNormal(format, arguments);
        loggerUtil.trace(currentMethodParam, msg);
    }

    @Override
    public void trace(String msg, Throwable t) {

    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return false;
    }

    @Override
    public void trace(Marker marker, String msg) {

    }

    @Override
    public void trace(Marker marker, String format, Object arg) {

    }

    @Override
    public void trace(Marker marker, String format, Object arg1, Object arg2) {

    }

    @Override
    public void trace(Marker marker, String format, Object... argArray) {

    }

    @Override
    public void trace(Marker marker, String msg, Throwable t) {

    }

    @Override
    public boolean isDebugEnabled() {
        return false;
    }

    @Override
    public void debug(String msg) {
        CurrentMethodParam currentMethodParam = CurrentMethodInfo.getMethodInfo();
        loggerUtil.debug(currentMethodParam, msg);
    }

    @Override
    public void debug(String format, Object arg) {
        CurrentMethodParam currentMethodParam = CurrentMethodInfo.getMethodInfo();
        String msg = ParserPlaceHolder.parseNormal(format, arg);
        loggerUtil.debug(currentMethodParam, msg);
    }

    @Override
    public void debug(String format, Object arg1, Object arg2) {
        CurrentMethodParam currentMethodParam = CurrentMethodInfo.getMethodInfo();
        String msg = ParserPlaceHolder.parseNormal(format, arg1, arg2);
        loggerUtil.debug(currentMethodParam, msg);
    }

    @Override
    public void debug(String format, Object... arguments) {
        CurrentMethodParam currentMethodParam = CurrentMethodInfo.getMethodInfo();
        String msg = ParserPlaceHolder.parseNormal(format, arguments);
        loggerUtil.debug(currentMethodParam, msg);
    }

    @Override
    public void debug(String msg, Throwable t) {

    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return false;
    }

    @Override
    public void debug(Marker marker, String msg) {

    }

    @Override
    public void debug(Marker marker, String format, Object arg) {

    }

    @Override
    public void debug(Marker marker, String format, Object arg1, Object arg2) {

    }

    @Override
    public void debug(Marker marker, String format, Object... arguments) {

    }

    @Override
    public void debug(Marker marker, String msg, Throwable t) {

    }

    @Override
    public boolean isInfoEnabled() {
        return false;
    }

    @Override
    public void info(String msg) {
        CurrentMethodParam currentMethodParam = CurrentMethodInfo.getMethodInfo();
        loggerUtil.info(currentMethodParam, msg);
    }

    @Override
    public void info(String format, Object arg) {
        CurrentMethodParam currentMethodParam = CurrentMethodInfo.getMethodInfo();
        String msg = ParserPlaceHolder.parseNormal(format, arg);
        loggerUtil.info(currentMethodParam, msg);
    }

    @Override
    public void info(String format, Object arg1, Object arg2) {
        CurrentMethodParam currentMethodParam = CurrentMethodInfo.getMethodInfo();
        String msg = ParserPlaceHolder.parseNormal(format, arg1, arg2);
        loggerUtil.info(currentMethodParam, msg);
    }

    @Override
    public void info(String format, Object... arguments) {
        CurrentMethodParam currentMethodParam = CurrentMethodInfo.getMethodInfo();
        String msg = ParserPlaceHolder.parseNormal(format, arguments);
        loggerUtil.info(currentMethodParam, msg);
    }

    @Override
    public void info(String msg, Throwable t) {

    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return false;
    }

    @Override
    public void info(Marker marker, String msg) {

    }

    @Override
    public void info(Marker marker, String format, Object arg) {

    }

    @Override
    public void info(Marker marker, String format, Object arg1, Object arg2) {

    }

    @Override
    public void info(Marker marker, String format, Object... arguments) {

    }

    @Override
    public void info(Marker marker, String msg, Throwable t) {

    }

    @Override
    public boolean isWarnEnabled() {
        return false;
    }

    @Override
    public void warn(String msg) {
        CurrentMethodParam currentMethodParam = CurrentMethodInfo.getMethodInfo();
        loggerUtil.warn(currentMethodParam, msg);
    }

    @Override
    public void warn(String format, Object arg) {
        CurrentMethodParam currentMethodParam = CurrentMethodInfo.getMethodInfo();
        String msg = ParserPlaceHolder.parseNormal(format, arg);
        loggerUtil.warn(currentMethodParam, msg);
    }

    @Override
    public void warn(String format, Object... arguments) {
        CurrentMethodParam currentMethodParam = CurrentMethodInfo.getMethodInfo();
        String msg = ParserPlaceHolder.parseNormal(format, arguments);
        loggerUtil.warn(currentMethodParam, msg);
    }

    @Override
    public void warn(String format, Object arg1, Object arg2) {
        CurrentMethodParam currentMethodParam = CurrentMethodInfo.getMethodInfo();
        String msg = ParserPlaceHolder.parseNormal(format, arg1, arg2);
        loggerUtil.warn(currentMethodParam, msg);
    }

    @Override
    public void warn(String msg, Throwable t) {

    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return false;
    }

    @Override
    public void warn(Marker marker, String msg) {

    }

    @Override
    public void warn(Marker marker, String format, Object arg) {

    }

    @Override
    public void warn(Marker marker, String format, Object arg1, Object arg2) {

    }

    @Override
    public void warn(Marker marker, String format, Object... arguments) {

    }

    @Override
    public void warn(Marker marker, String msg, Throwable t) {

    }

    @Override
    public boolean isErrorEnabled() {
        return false;
    }

    @Override
    public void error(String msg) {
        CurrentMethodParam currentMethodParam = CurrentMethodInfo.getMethodInfo();
        loggerUtil.error(currentMethodParam, msg);
    }

    @Override
    public void error(String format, Object arg) {
        CurrentMethodParam currentMethodParam = CurrentMethodInfo.getMethodInfo();
        String msg = ParserPlaceHolder.parseNormal(format, arg);
        loggerUtil.error(currentMethodParam, msg);
    }

    @Override
    public void error(String format, Object arg1, Object arg2) {
        CurrentMethodParam currentMethodParam = CurrentMethodInfo.getMethodInfo();
        String msg = ParserPlaceHolder.parseNormal(format, arg1, arg2);
        loggerUtil.error(currentMethodParam, msg);
    }

    @Override
    public void error(String format, Object... arguments) {
        CurrentMethodParam currentMethodParam = CurrentMethodInfo.getMethodInfo();
        String msg = ParserPlaceHolder.parseNormal(format, arguments);
        loggerUtil.error(currentMethodParam, msg);
    }

    @Override
    public void error(String msg, Throwable t) {
        CurrentMethodParam currentMethodParam = CurrentMethodInfo.getMethodInfo();
        String format = msg + ThrowableToString.errorInfoToString(t);
        loggerUtil.error(currentMethodParam, format);
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return false;
    }

    @Override
    public void error(Marker marker, String msg) {

    }

    @Override
    public void error(Marker marker, String format, Object arg) {

    }

    @Override
    public void error(Marker marker, String format, Object arg1, Object arg2) {

    }

    @Override
    public void error(Marker marker, String format, Object... arguments) {

    }

    @Override
    public void error(Marker marker, String msg, Throwable t) {

    }

}
