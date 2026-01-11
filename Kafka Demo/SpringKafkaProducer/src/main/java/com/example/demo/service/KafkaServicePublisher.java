package com.example.demo.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class KafkaServicePublisher {
		
	@Autowired
	private KafkaTemplate<String, Object> template;
	
	public void sendMessageToTopic(String message) throws InterruptedException, ExecutionException {
		CompletableFuture<SendResult<String, Object>> future = template.send("Keshaw-topic", message);
		future.whenComplete((result, ex) -> {
			if(ex == null) {
				System.out.println("Message sent >> " + message + " with offset >> " + result.getRecordMetadata().offset());
			} else {
				System.out.println("Unnable to send message >> " + message + " exception is "  +ex.getMessage());
			}
		});
	}
}
