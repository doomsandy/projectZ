package com.application.security;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
@WebFilter("/user/*")
public class AuthHeaderFilter implements Filter {
    private final FeignClient feignClient;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String encodedAuthToken = httpServletRequest.getHeader("auth");

        if (encodedAuthToken != null) {

            String decodedAuthToken = Base64Decoder.decodeBase64(encodedAuthToken);

            String jti = JtiTokenExtractor.extractJti(decodedAuthToken);

            Map<String, String> requestBody = new HashMap<>();
            requestBody.put("jti", jti);

            feignClient.sendJtiToStub(requestBody);

            chain.doFilter(request, response);
        } else {
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpServletResponse.getWriter().write("No 'auth' header!");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }
}
