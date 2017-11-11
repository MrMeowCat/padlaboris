package com.instinctools.padlaboris.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultTokenService implements TokenService{
    @Override
    public String getToken(String username, String password) throws Exception {
        return null;
    }
}
