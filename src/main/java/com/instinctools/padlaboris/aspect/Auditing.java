package com.instinctools.padlaboris.aspect;

/**
 * Auditing interface.
 */
public interface Auditing {

    /**
     * Service logging audit.
     *
     * @param service service name
     * @param method  method name
     * @param args    method parameters
     */
    void logService(String service, String method, String args);
}
