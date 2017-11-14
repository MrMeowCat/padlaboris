package com.instinctools.padlaboris.application.security.service.jwt;

/**
 * Interface for work with Token.
 */
public interface TokenService {

    String getToken(String username, String password) throws Exception;
}
