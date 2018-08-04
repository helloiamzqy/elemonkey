package com.monkey.ele.merchant.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Component
@Aspect
public class WebLogAspect {
    private static final Logger LOGGER = Logger.getLogger(WebLogAspect.class);
    private final String POINT_CUT = "execution(public * com.monkey.ele.merchant.controller..*.*(..))";


    @Pointcut(POINT_CUT)
    public void webLog() {

    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {

        LOGGER.info("Request_Controller : " + joinPoint.getSignature().getDeclaringTypeName());
        LOGGER.info("Request_Method : " + joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        for(Object obj : args){
            if(obj != null){
                LOGGER.info("Request_Param : " + obj.getClass().getSimpleName() + " —— " + obj);
            }else{
                LOGGER.info("Request_Param : " + obj);
            }
        }
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        LOGGER.info("RESPONSE : " + ret);
    }
}