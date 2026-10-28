package com.arti.SpringBootCoreDemo;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("payment-property")
public class PaymentProperties {
    private String type;
    private int retryCount;
    private Boolean enabled;
    private int timeout;


    public String getType() {
        return type;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
