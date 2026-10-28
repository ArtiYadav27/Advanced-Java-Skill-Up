package org.arti;

public class PaymentService {

    private String type;
    private int retryCount;

    public PaymentService(String type, int retryCount){
        this.type=type;
        this.retryCount = retryCount;
        System.out.println("payment type:"+type + " retry count :" + retryCount);
    }

    public void pay(){
        System.out.println("PaymentService success...");
    }
}
