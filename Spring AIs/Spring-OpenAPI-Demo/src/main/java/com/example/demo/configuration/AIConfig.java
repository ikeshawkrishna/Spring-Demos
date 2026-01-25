package com.example.demo.configuration;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AIConfig {

	@Bean(name = "openAIChatClient")
	public ChatClient openAIChatClient(OpenAiChatModel openAiChatModel) {
		return ChatClient.builder(openAiChatModel).build();
	}
	
	@Bean(name = "geminiAIChatClient")
	public ChatClient geminiAIChatClient(GoogleGenAiChatModel googleGenAiChatModel) {
		return ChatClient.builder(googleGenAiChatModel).build();
	}
	
}
