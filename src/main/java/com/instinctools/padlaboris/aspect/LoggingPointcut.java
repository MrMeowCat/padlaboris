package com.instinctools.padlaboris.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Service pointcut holder.
 */
@Aspect
public class LoggingPointcut {

    @Pointcut("execution(public * com.instinctools.padlaboris.domain.service..*(..))"
            + "||execution(public * com.instinctools.padlaboris.application.security.service..*(..))")
    public void logService() {
        // avoid implementation
    }
}
