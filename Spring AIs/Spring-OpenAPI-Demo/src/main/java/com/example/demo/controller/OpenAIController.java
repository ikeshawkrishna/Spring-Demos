package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.OpenAIService;

@RestController
@RequestMapping("/api")
public class OpenAIController {

	private final OpenAIService service;
	
	public OpenAIController(OpenAIService service) {
		this.service = service;
	}
	
//	@GetMapping("/{message}")
//	public String callModel(@PathVariable String message) {
//		return service.callModel_v2(message);
//	}
	
	@GetMapping("/{message}")
	public String callMultiModel(@RequestParam("model") String model, @PathVariable String message) {
		return service.callMultiModel(model, message);
	}
	
	
}
