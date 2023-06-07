package com.targetindia.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
    public LoggingAspect() {
        log.trace("LoggingAspect constructor called");
    }

    // An Aspect is a class (an abstraction) consisting of one or more advices (solution to the actual concern)
    // Concern to address -> log the entry and exit of every method call on an object of ProductDao

    @Pointcut("execution(* com.targetindia.dao.ProductDao.*(..))") // reusable pointcut
    public void pc1(){}

    @Before("pc1()")
    // @Before("execution(* com.targetindia.dao.ProductDao.*(..))")
    public void logMethodEntry(JoinPoint jp){
        log.trace("entering method '{}' of '{}' from '{}' class using arguments {}",
                jp.getSignature().getName(),
                jp.getSignature().getDeclaringType(),
                jp.getTarget().getClass().getName(),
                Arrays.toString(jp.getArgs()));
    }

    @After("pc1()")
    public void logMethodExit(JoinPoint jp){
        log.trace("exited method '{}' of '{}' from '{}' class using arguments {}",
                jp.getSignature().getName(),
                jp.getSignature().getDeclaringType(),
                jp.getTarget().getClass().getName(),
                Arrays.toString(jp.getArgs()));
    }
}
