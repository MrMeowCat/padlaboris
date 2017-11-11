package com.instinctools.padlaboris.security.filter;


import com.instinctools.padlaboris.security.service.TokenAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthenticationTokenFilter extends GenericFilterBean {

    private final TokenAuthenticationService authenticationService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        final HttpServletRequest httpRequest = (HttpServletRequest) request;

        final Authentication authentication = authenticationService.authenticate(httpRequest);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
        SecurityContextHolder.getContext().setAuthentication(null);
    }
}
