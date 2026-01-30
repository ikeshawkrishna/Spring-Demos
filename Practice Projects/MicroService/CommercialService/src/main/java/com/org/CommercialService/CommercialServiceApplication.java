package com.org.CommercialService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableFeignClients
public class CommercialServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommercialServiceApplication.class, args);
		System.out.println("I am working fine");
	}

}
