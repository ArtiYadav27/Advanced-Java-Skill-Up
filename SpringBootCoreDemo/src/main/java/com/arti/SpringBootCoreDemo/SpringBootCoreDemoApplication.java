package com.arti.SpringBootCoreDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootCoreDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(SpringBootCoreDemoApplication.class, args);






//		PaymentGateway gateway=context.getBean(PaymentGateway.class);
//		gateway.print();


//		gateway.setType("paytm");
//		gateway.setRetryCount(6);

//		System.out.println(gateway.getType());
//		System.out.println(gateway.getRetryCount());
//		System.out.println(gateway.getEnabled());
//		System.out.println(gateway.getTimeout());
	}

}
