package com.example.JPAApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JpaApplication.class, args);


	}

//	@Bean
//	public CommandLineRunner  commandLineRunner(AuthorRepo authorRepo){
//		return args -> {
//			Author author = new Author();
//			author.setFirstName("keshaw");
//			author.setLastName("Krishna");
//			author.setEmail("K@g.com");
//			author.setAge(23);
//			author.setCreatedData(LocalDateTime.now());
//
//			authorRepo.save(author);
//		};
//	}

}
