package com.example.FilterDemo.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

//@Component
public class ResponseHeaderFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletResponse res=(HttpServletResponse) response;
        HttpServletRequest req=(HttpServletRequest) request;

        String requestId= UUID.randomUUID().toString();
        res.getHeader("x-requestId-id"+ requestId);
        chain.doFilter(request,response);
    }
}
