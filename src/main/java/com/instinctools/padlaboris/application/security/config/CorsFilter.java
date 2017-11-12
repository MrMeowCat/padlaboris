package com.instinctools.padlaboris.application.security.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Custom Filter.
 */
@Component
@Slf4j
public class CorsFilter implements Filter {

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {

        //init method.
    }

    @Override
    public void doFilter(final ServletRequest req, final ServletResponse res,
                         final FilterChain chain) throws IOException, ServletException {

        final HttpServletResponse response = (HttpServletResponse) res;

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods",
                "POST, GET, PUT, OPTIONS, DELETE, PATCH");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-auth-token, Content-Type");
        response.setHeader("Access-Control-Expose-Headers", "x-auth-token, Content-Type");

        final HttpServletRequest request = (HttpServletRequest) req;

        if (request.getMethod().equals("OPTIONS")) {

            try {
                response.getWriter().print("OK");
                response.getWriter().flush();
            } catch (IOException e) {

                log.error("Error", e);
            }
        } else {

            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

        //destroy method.
    }
}
