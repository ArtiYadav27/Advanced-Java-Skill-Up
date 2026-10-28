package com.example.FilterDemo.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;


//@Component
public class ResponseBodyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse res=(HttpServletResponse) response;
        HttpServletRequest req=(HttpServletRequest) request;

        ContentCachingResponseWrapper wrappedResponse=new ContentCachingResponseWrapper(res);
        chain.doFilter(request,wrappedResponse);

        byte[] originalBodyBytes=wrappedResponse.getContentAsByteArray();

        String originalBody=new String(originalBodyBytes);


        String modifiedBody=
                """
                    {
                    "originalResponse"=%s,
                    "appMessage"="modified response through wrapper"
                    }
                """.formatted(originalBody);

        wrappedResponse.resetBuffer();
        wrappedResponse.getWriter().write(modifiedBody);
        wrappedResponse.copyBodyToResponse();

    }
}
