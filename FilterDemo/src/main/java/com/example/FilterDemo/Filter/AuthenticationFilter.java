package com.example.FilterDemo.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
//@Order(1)
public class AuthenticationFilter implements Filter {
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse res=(HttpServletResponse) response;

        String token=req.getHeader("token");
        String apiKey=req.getHeader("x-api-key");
        if(token == null || !token.equals("12345")){
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        if(apiKey==null || !apiKey.equals("secret123")){
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.setContentType("Application/josn");
            res.getWriter().write(
                    "{\n" +
                            "    \"message\":\"missing API Key\"\n" +
                            "}"
            );
            return;
        }
        chain.doFilter(request,response);
    }
}
