package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.OpenAIService;

@RestController
@RequestMapping("/api")
public class OpenAIController {
	
	private final OpenAIService openaiservice;
	
	public OpenAIController(OpenAIService openaiservice) {
		this.openaiservice = openaiservice;
	}

	@GetMapping("/{prompt}")
	public String callService(@PathVariable String prompt) {
		return openaiservice.callService(prompt);
	}
}
