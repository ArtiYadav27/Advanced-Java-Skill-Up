package org.arti;

public class OrderService {
    private PaymentService payment;

    public void setPayment(PaymentService payment) {
        this.payment=payment;
    }
//    public OrderService(PaymentService payment){
//        this.payment=payment;
//    }

//    public OrderService(){
//        System.out.println("Order service bean created.");
//    }


    public void placeOrder(){
        payment.pay();
        System.out.println("Order placed.");
    }

}
