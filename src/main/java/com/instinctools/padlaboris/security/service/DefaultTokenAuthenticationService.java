package com.instinctools.padlaboris.security.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public class DefaultTokenAuthenticationService implements TokenAuthenticationService{

    @Override
    public Authentication authenticate(HttpServletRequest request) {
        return null;
    }
}
