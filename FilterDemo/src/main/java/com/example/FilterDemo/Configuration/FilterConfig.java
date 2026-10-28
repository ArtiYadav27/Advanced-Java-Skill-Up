package com.example.FilterDemo.Configuration;

import com.example.FilterDemo.Filter.DummyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig{

    FilterRegistrationBean<DummyFilter> getDummyFilter(){
        FilterRegistrationBean<DummyFilter> registrationBean=new FilterRegistrationBean<>();
        registrationBean.setFilter(new DummyFilter());
//        registrationBean.setOrder(2);
        registrationBean.addUrlPatterns("/api/* ,/*");
        return registrationBean;
    }
}
