package com.example.demo.controller;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.OpenAIService;

@RestController
@RequestMapping("/api")
public class OpenAIController {

	
	private final OpenAIService service;
	
	public OpenAIController(OpenAIService service) {
		this.service = service;
	}
	
	
	@GetMapping("/ask/{message}")
	public String AskAI(@PathVariable String message) {
		return service.AskAI(message);
	}
}
