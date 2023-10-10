package com.cun.util.es.utils;



import com.cun.util.es.module.CurrentMethodParam;

public class CurrentMethodInfo {

    public static final int originStackIndex = 4;

    public static CurrentMethodParam getMethodInfo() {
        CurrentMethodParam currentMethodParam = new CurrentMethodParam();
        currentMethodParam.setFileName(getFileName());
        currentMethodParam.setClassName(getClassName());
        currentMethodParam.setMethodName(getMethodName());
        currentMethodParam.setLineNumber(getLineNumber());
        return currentMethodParam;
    }

    public static String getFileName() {
        try {
            return Thread.currentThread().getStackTrace()[originStackIndex].getFileName();
        } catch (Exception e) {
            return "";
        }
    }

    public static String getClassName() {
        try {
            return Thread.currentThread().getStackTrace()[originStackIndex].getClassName();
        } catch (Exception e) {
            return "";
        }
    }

    public static String getMethodName() {
        try {
            return Thread.currentThread().getStackTrace()[originStackIndex].getMethodName();
        } catch (Exception e) {
            return "";
        }
    }

    public static int getLineNumber() {
        try {
            return Thread.currentThread().getStackTrace()[originStackIndex].getLineNumber();
        } catch (Exception e) {
            return 0;
        }
    }

}
