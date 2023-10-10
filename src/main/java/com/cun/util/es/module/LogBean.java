package com.cun.util.es.module;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.cun.util.es.utils.CommUtils;


public class LogBean {
    private String taskName;
    private String account;
    private String userId;
    private String method;
    private String methondType;
    private String status;
    private String token;
    private String message;
    private String exception;
    private String cost;
    private String ip;
    private String hostName;
    private String logTime;
    private static JSONObject jsonStr;

    public LogBean() {
        this.init();
    }

    public LogBean(String taskName, String account, String userId, String method, String methondType, String status, String token, String message, String exception, String cost) {
        this.taskName = taskName;
        this.account = account;
        this.userId = userId;
        this.method = method;
        this.methondType = methondType;
        this.status = status;
        this.token = token;
        this.message = message;
        this.exception = exception;
        this.cost = cost;
        this.init();
    }

    public void init() {
        this.ip = CommUtils.getLocalAddress().getHostAddress();
        this.hostName = CommUtils.getLocalAddress().getHostName();
        this.logTime = CommUtils.formatDate();
    }

    public String getCost() {
        return this.cost;
    }

    public LogBean setCost(String cost) {
        this.cost = cost;
        return this;
    }

    public String getHostName() {
        return this.hostName;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public LogBean setTaskName(String taskName) {
        this.taskName = taskName;
        return this;
    }

    public String getAccount() {
        return this.account;
    }

    public LogBean setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getUserId() {
        return this.userId;
    }

    public LogBean setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getMethod() {
        return this.method;
    }

    public LogBean setMethod(String method) {
        this.method = method;
        return this;
    }

    public String getMethondType() {
        return this.methondType;
    }

    public LogBean setMethondType(String methondType) {
        this.methondType = methondType;
        return this;
    }

    public String getStatus() {
        return this.status;
    }

    public LogBean setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getToken() {
        return this.token;
    }

    public LogBean setToken(String token) {
        this.token = token;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public LogBean setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getException() {
        return this.exception;
    }

    public LogBean setException(String exception) {
        this.exception = exception;
        return this;
    }

    public String getIp() {
        return this.ip;
    }

    public String getLogTime() {
        return this.logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public String log2JsonStr() {
        try {
            return JSON.toJSONString(this);
        } catch (Exception var2) {
            return "";
        }
    }

}

