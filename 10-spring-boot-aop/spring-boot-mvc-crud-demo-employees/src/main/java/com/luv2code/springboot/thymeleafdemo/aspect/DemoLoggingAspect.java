package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {
private Logger myLogger=Logger.getLogger(getClass().getName());

@Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    @Before("forAppFlow()")
    private void before(JoinPoint joinPoint){
    String method=joinPoint.getSignature().toShortString();
    myLogger.info("===========> in @Before calling method  "+method);
    Object args[]= joinPoint.getArgs();
    for(Object tempArgs:args){
        myLogger.info("===========> in argument is   "+tempArgs);
    }
    }

    @AfterReturning(pointcut = "forAppFlow()",returning = "res")
    private void afterReturning(JoinPoint joinPoint,Object res){
        String method=joinPoint.getSignature().toShortString();
        myLogger.info("===========> in @AfterReturning calling method  "+method);
        myLogger.info("===========> in argument is   "+res);
    }

}
