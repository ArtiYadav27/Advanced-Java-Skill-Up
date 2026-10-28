package com.arti.SpringBootCoreDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {

    private final PaymentProperties properties;

    public PaymentGateway(PaymentProperties properties) {
        this.properties = properties;
    }

    public String getType() {
        return properties.getType();
    }

    public int getRetryCount() {
        return properties.getRetryCount();
    }

    public Boolean getEnabled() {
        return properties.getEnabled();
    }

    public int getTimeout() {
        return properties.getTimeout();
    }


    public void print(){
        System.out.println(getType());
        System.out.println(getRetryCount());
        System.out.println(getEnabled());
        System.out.println(getTimeout());
    }







//    @Value("${paymentGateway.type:Razorpay}")
//    private String type;
//
//    @Value("${paymentGateway.retry-count}")
//    private int retryCount;


//    public PaymentGateway(@Value("${paymentGateway.type}") String type,@Value("${paymentGateway.retry-count}") int retryCount){
//        this.type=type;
//        this.retryCount=retryCount;
//    }

//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public int getRetryCount() {
//        return retryCount;
//    }
//
//    public void setRetryCount(int retryCount) {
//        this.retryCount = retryCount;
//    }
}
