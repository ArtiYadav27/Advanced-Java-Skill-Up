package com.arti.aopIntroductionDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
@SpringBootApplication
public class AopIntroductionDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(AopIntroductionDemoApplication.class, args);
	}

}
