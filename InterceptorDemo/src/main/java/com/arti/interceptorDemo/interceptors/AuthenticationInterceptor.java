package com.arti.interceptorDemo.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler)
          {
        String apiKey=request.getHeader("x-api-key");
        if(apiKey==null || !apiKey.equals("123")){
            response.setStatus(401);
            return false;}
        return true;

    }
}
