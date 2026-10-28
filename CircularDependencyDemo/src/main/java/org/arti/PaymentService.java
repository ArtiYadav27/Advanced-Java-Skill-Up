package org.arti;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    OrderService orderService;

    public PaymentService(OrderService orderService){
        this.orderService=orderService;
    }

    public void pay(){
        System.out.println("Payment successfull..");
        orderService.getOrderDetails();
    }
}
