package com.arti.interceptorDemo.interceptors;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LogginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                              HttpServletResponse response,
                              Object handler)
            throws Exception {

        System.out.println("Http method:"+request.getMethod());
        System.out.println("Request URI:"+request.getRequestURI());
        System.out.println("Request Parameters:"+ request.getQueryString());
        System.out.println("Client IP:"+request.getRemoteAddr());

        if(handler instanceof HandlerMethod handlerMethod){
            String controllerName=handlerMethod.getBeanType().getName();
            String methodName=handlerMethod.getMethod().getName();
            System.out.println("controllerName:"+ controllerName +"\nmethodName:"+ methodName);
        }
        System.out.println("inside preHandle method");
        return true; //to indicate to move to next step in the execution flow
    }
//    @Override
//    public void postHandle(HttpServletRequest request,
//                            HttpServletResponse response,
//                            Object handler,
//                            @Nullable ModelAndView modelAndView)
//            throws Exception {
//        System.out.println("inside postHandle method");
//    }
    @Override
    public void afterCompletion(HttpServletRequest request,
                                 HttpServletResponse response,
                                 Object handler,
                                 @Nullable Exception ex)
            throws Exception {
        System.out.println("Response status:"+response.getStatus());
    }
}
