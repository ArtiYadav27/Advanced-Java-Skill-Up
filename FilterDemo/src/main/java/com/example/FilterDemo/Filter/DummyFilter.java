package com.example.FilterDemo.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class DummyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req=(HttpServletRequest) request;
        String uri=req.getRequestURI();
        if(!uri.startsWith("/api/*")){
            chain.doFilter(request,response);
        }


        System.out.println("Dummy filter called");
        chain.doFilter(request,response);
    }
}
