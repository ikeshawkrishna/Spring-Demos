package com.example.demo.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.KafkaServicePublisher;

@RestController
@RequestMapping("/producer")
public class KafkaController {

	@Autowired
	private KafkaServicePublisher servicePublisher;
	
	@GetMapping("/publish/{message}")
	public ResponseEntity<?> publishMessage(@PathVariable String message){
		try {
			for(int i = 1; i < 10000; i++) {
				servicePublisher.sendMessageToTopic(message + " >> "  + i);
			}
			
			return ResponseEntity.ok("Published");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
}
