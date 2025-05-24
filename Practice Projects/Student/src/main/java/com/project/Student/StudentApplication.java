package com.project.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class StudentApplication {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StudentApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner (){
		return args -> {
			String sql = "SELECT * FROM dbo.msme_roi_master";
			List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
			System.out.println("maps >>>> " + maps);
		};
	}

}
