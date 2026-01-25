package com.example.demo.service;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class OpenAIService {

	@Autowired
	private OpenAiChatModel openAiChatModel;
	
	public String AskAI(@PathVariable String message) {
		return openAiChatModel
			.call(message);
	}
}
