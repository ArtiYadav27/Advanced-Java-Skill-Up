package com.arti.SpringBootCoreDemo;


import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements CommandLineRunner/*ApplicationRunner*/ {

    private PaymentGateway gateway;

    public DemoRunner(PaymentGateway gateway) {
        this.gateway = gateway;
    }

//    @Override
//    public void run(ApplicationArguments args) throws Exception { //applicationrunner method
//        gateway.print();
//    }

    @Override
    public void run(String... args) throws Exception { //commandlinerunner method
        gateway.print();
    }
}
