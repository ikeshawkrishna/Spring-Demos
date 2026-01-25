package com.example.demo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpenAIService {

	@Autowired
	private OpenAiChatModel openAiChatModel;

//	private final ChatClient chatClient;
	private final ChatClient openAIChatClient;
	private final ChatClient geminiAIChatClient;

	public OpenAIService(ChatClient openAIChatClient, ChatClient geminiAIChatClient) {
//		chatClient = builder.build();
		this.openAIChatClient = openAIChatClient;
		this.geminiAIChatClient = geminiAIChatClient;
	}

//	Using OpenAIModel itself
	public String callModel_v1(String message) {
		return openAiChatModel.call(message);
	}

//	Using ChatClient
//	public String callModel_v2(String message) {
//		return chatClient.prompt().user(message).call().content();
//	}

	public String callMultiModel(String model, String message) {
		String result = null;

		result = switch (model) {
			case "openai": {
				yield callThrough_OpenAI(message);
			}
			case "gemini" : {
				yield callThrough_GeminiAI(message);
			}
			default: {
				yield "Please provide valid provider";
			}
		};

		return result;
	}

	private String callThrough_OpenAI(String message) {
		return openAIChatClient
				.prompt()
				.user(message)
				.call()
				.content();
	}

	private String callThrough_GeminiAI(String message) {
		return geminiAIChatClient
				.prompt()
				.user(message)
				.call()
				.content();
	}

}
