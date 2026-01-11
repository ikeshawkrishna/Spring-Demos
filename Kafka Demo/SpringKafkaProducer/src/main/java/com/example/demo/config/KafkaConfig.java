package com.example.demo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

	@Bean
	public NewTopic createTopic() {
		return new NewTopic("Keshaw-topic", 5, (short) 1);
	}
}
