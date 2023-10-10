package com.cun.util.es.aop;


import com.alibaba.fastjson.JSON;
import com.cun.util.es.module.CurrentMethodParam;
import com.cun.util.es.module.LogBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * linlc
 */

@Slf4j
@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Component
public class LoggetUtilAspect {


    @Pointcut("execution(* com.cun.util.es.utils.LoggerUtil.*(..))")
    public void serviceimplLog() {
    }

    @Around("serviceimplLog()")
    public Object doAroundimpl(ProceedingJoinPoint point) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("切面统一处理日志：" + Thread.currentThread().getName());
        String methodName = "";
        String account = null;
        LogBean logBean = new LogBean();
        try {
            Object[] args = point.getArgs();
            for (Object arg : args) {
                if (arg instanceof CurrentMethodParam) {
                    CurrentMethodParam currentMethodParam = (CurrentMethodParam) arg;
                    methodName = currentMethodParam.getClassName() + "." + currentMethodParam.getMethodName();
                } else {
                    logBean.setMessage(arg.toString());
                    log.info(arg.toString());
                }
            }
        } catch (Throwable e) {
            if (StringUtils.isBlank(methodName)) {
                String simpleName = point.getSignature().getName();
                methodName = point.getSignature().getDeclaringType().getSimpleName() + "." + simpleName;
            }
            log.info("方法：{}执行结束,用户：{},返回异常：：：{}", methodName, account, e);
            logBean.setException("方法" + methodName + "返回异常");
        } finally {
            logBean.setMethod(methodName);
            logBean.setAccount(account);
            stopWatch.stop();
            StopWatch.TaskInfo taskInfo = stopWatch.getLastTaskInfo();
            logBean.setCost(String.valueOf(taskInfo.getTimeMillis()));
        }

        // TODO 将日志落地
        log.info(JSON.toJSONString(logBean));

        return null;
    }

}