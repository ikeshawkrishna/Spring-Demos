package com.project.Student;

import com.project.Student.Model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StudentApplication.class, args);
	}

}
