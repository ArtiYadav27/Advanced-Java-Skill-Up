package org.arti;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        //get bean by type
//        OrderService order=context.getBean(OrderService.class);

        //get bean by id
//        OrderService order= (OrderService) context.getBean("orderService");

        //get by name and type similarly id
//        OrderService order=context.getBean("orderServiceBean", OrderService.class);

        //get bean by id and type
        OrderService order=context.getBean("orderService", OrderService.class);
        order.placeOrder();

    }
}