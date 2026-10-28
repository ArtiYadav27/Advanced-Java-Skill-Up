package com.example.FilterDemo.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;


//@Component
//@Order(2)
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        Long startTime=System.currentTimeMillis();

        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse res=(HttpServletResponse) response;

        String requestID= UUID.randomUUID().toString();
        res.setHeader("X-Request-ID",requestID);



        //logging request
        System.out.println("incoming request"+
                req.getMethod()+" "+
                req.getRequestURI());


        try {
            chain.doFilter(request,response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            Long duration=System.currentTimeMillis()-startTime;
            System.out.println("status code:"+ res.getStatus());
            System.out.println("API respoonse time:" +duration);
        }


    }
}
