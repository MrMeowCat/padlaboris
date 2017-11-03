package com.instinctools.padlaboris.aspect;

import javassist.bytecode.stackmap.TypeData;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(TypeData.ClassName.class);

    @Pointcut("@annotation(Auditable)")
    public void PointCutDefinition() {
    }

    @Pointcut("execution(* *(..))")
    public void atExecution() {
    }

    @Before("PointCutDefinition() && atExecution()")
    public void beforeLoggingAdvice(JoinPoint joinPoint) {
        logger.debug("HELLO EBAT");
    }

    @After("PointCutDefinition() && atExecution()")
    public void afterLoggingAdvice(JoinPoint joinPoint) {
        logger.debug("BB NAXYI");
    }
}
