package com.instinctools.padlaboris.aspect;

public interface Auditing {

    void logService(String service, String method, String args);
}
