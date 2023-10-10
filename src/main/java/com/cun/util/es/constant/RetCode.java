package com.cun.util.es.constant;

/**
 * Created by linlc
 */

public enum RetCode {
    SUCCESS(0, "结果返回成功"),
    EXCEPTION(1, "结果返回异常"),
    SHOULD_LOGIN(2, "请登录"),
    ERROR_LOGIN(3, "登录失败"),
    NOT_LOGIN(5, "未登录"),
    SUBMIT_QUEUE(10, "任务已提交队列"),
    ACK_TASK(11, "channel端ack消息"),
    TASK_PRODUCER_SUBMIT(12, "任务已提交队列"),
    TASK_CONSUMER_ACCEPT(13, "任务已接收"),
    TASK_PRODUCER_EXCEPTION(20, "调度任务提交队列发生异常"),
    TASK_CONSUMER_EXCEPTION(21, "调度任务消费队列发生异常"),
    FAILURE(31, "任务返回失败"),
    PART_FAILURE(32, "部分任务返回失败");

    private int code;
    private String message;

    RetCode(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public int code() {
        return this.code;
    }

    public String msg() {
        return this.message;
    }

}
