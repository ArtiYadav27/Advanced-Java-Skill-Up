package com.arti.interceptorDemo.config;


import com.arti.interceptorDemo.interceptors.AuthenticationInterceptor;
import com.arti.interceptorDemo.interceptors.AuthorizationInterceptor;
import com.arti.interceptorDemo.interceptors.LogginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    public LogginInterceptor logginInterceptor;
    public AuthenticationInterceptor authenticationInterceptor;
    public AuthorizationInterceptor authorizationInterceptor;

    public WebConfig(LogginInterceptor logginInterceptor, AuthenticationInterceptor authenticationInterceptor, AuthorizationInterceptor authorizationInterceptor){
        this.logginInterceptor=logginInterceptor;
        this.authenticationInterceptor=authenticationInterceptor;
        this.authorizationInterceptor = authorizationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){

        registry.addInterceptor(authenticationInterceptor);
//                .addPathPatterns("/api/**")
//                .excludePathPatterns("/api/auth/login", "/api/public/**")
//                .order(1);

        registry.addInterceptor(logginInterceptor)
                .order(3);
        registry.addInterceptor(authorizationInterceptor)
                .order(2);


    }
}
