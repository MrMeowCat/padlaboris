package com.instinctools.padlaboris.aspect;

import javassist.bytecode.stackmap.TypeData;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("@annotation(com.instinctools.padlaboris.aspect.Loggable)")
    public void PointCutDefinition() {
    }

    @Pointcut("execution(* *(..))")
    public void atExecution() {
    }

    @Before("atExecution() && PointCutDefinition()")
    public void beforeLoggingAdvice(JoinPoint joinPoint) {
        logger.info("SOMETHING");
    }

    @After("atExecution() && PointCutDefinition()")
    public void afterLoggingAdvice(JoinPoint joinPoint) {
        logger.info("SOMETHING");
    }
}
