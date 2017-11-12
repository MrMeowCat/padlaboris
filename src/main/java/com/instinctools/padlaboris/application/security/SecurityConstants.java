package com.instinctools.padlaboris.application.security;

/**
 * Security constants.
 */
public final class SecurityConstants {

    private SecurityConstants() {
    }

    /**
     * Header name.
     */
    public static final String AUTH_HEADER_NAME = "Token";

    /**
     * Key for token.
     */
    public static final String SECRET_KEY = "dc6589483a672de25ff765172494d42e138cd8a5";

    /**
     * Expiration time for access token.
     */
    public static final int TOKEN_EXPIRATION_TIME = 3;
}
