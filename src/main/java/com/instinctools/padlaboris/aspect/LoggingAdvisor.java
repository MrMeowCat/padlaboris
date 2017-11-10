package com.instinctools.padlaboris.aspect;

import com.instinctools.padlaboris.logging.Auditing;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LoggingAdvisor {

    private final Auditing auditing;

    @Before("com.instinctools.padlaboris.aspect.LoggingPointcut.logService()")
    public void serviceLogBeforeAdvice(final JoinPoint joinPoint) {
        auditing.logService(joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()));
    }
}
