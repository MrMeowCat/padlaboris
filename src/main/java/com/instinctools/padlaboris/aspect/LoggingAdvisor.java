package com.instinctools.padlaboris.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Logging Advisor.
 */
@Aspect
@Component
public class LoggingAdvisor {

    private final Auditing auditing;

    @Autowired
    public LoggingAdvisor(final Auditing auditing) {
        this.auditing = auditing;
    }

    @Before("com.instinctools.padlaboris.aspect.LoggingPointcut.logService()")
    public void serviceLogAdvice(final JoinPoint joinPoint) {
        auditing.logService(joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()));
    }
}
