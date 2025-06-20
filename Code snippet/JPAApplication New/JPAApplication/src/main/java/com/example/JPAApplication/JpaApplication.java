package com.example.JPAApplication;

import com.example.JPAApplication.Controller.CommonController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JpaApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(CommonController controller) {
		return args -> {
			System.out.println("Injected Port: " + controller.getDbname());
		};
	}

}
