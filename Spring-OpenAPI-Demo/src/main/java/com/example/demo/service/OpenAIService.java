package com.example.demo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class OpenAIService {
	
	private final ChatClient chatClient;
	
	public OpenAIService(ChatClient.Builder builder) {
		chatClient = builder.build();
	}

	public String callService(String prompt) {
		return chatClient
                .prompt(prompt)
                .call()
                .content();	}

}
