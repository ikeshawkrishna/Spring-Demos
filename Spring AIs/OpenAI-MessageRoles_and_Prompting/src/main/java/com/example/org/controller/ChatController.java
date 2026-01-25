package com.example.org.controller;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.org.service.ChatService;

@RestController
@RequestMapping("/api")
public class ChatController {
	
	private final ChatService chatService;
	
	public ChatController(ChatService chatService) {
		this.chatService = chatService;
	}

	@GetMapping("/{message}")
	public ChatResponse checkInsurancePolicy(@PathVariable String message) {
		return chatService.checkInsurancePolicy_v3(message);
	}
}
