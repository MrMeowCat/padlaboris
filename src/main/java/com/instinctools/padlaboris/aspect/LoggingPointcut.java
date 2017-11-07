package com.instinctools.padlaboris.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingPointcut {

    @Pointcut("execution(* com.instinctools.padlaboris.service.*(..))")
    public void logService() {

    }
}
