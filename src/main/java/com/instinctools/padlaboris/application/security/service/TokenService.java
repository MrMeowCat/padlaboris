package com.instinctools.padlaboris.application.security.service;

public interface TokenService {

    String getToken(final String username, final String password) throws Exception;
}
