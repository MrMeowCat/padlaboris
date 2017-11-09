package com.instinctools.padlaboris.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Auditor implementation.
 */
@Service
public class LoggerBaseAuditor implements Auditing {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerBaseAuditor.class);

    @Override
    public void logService(final String service, final String method, final String args) {
        LOGGER.info("Audit Log from Service: {} - from Method: {} - Args: {}", service, method, args);
    }
}
