package com.example.demo.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Customer;
import com.example.demo.dtosub.Person;

@Service
public class KafkaMessageListner {

	Logger log = LoggerFactory.getLogger(KafkaMessageListner.class);
	
//	@KafkaListener(topics = "Keshaw-topic-1", groupId = "keshaw-group")
//	public void consume(String message) {
//		log.info("consumer consumed the message >> " + message);
//	}
//	
	@KafkaListener(topics = "javatechie-demo1", groupId = "jt-group")
	public void consumeCustomer(Person customer) {
		log.info("consumer consumed the customer >> " + customer.toString());
	}
	
//	@KafkaListener(topics = "javatechie-demo",groupId = "jt-group")
//    public void consumeEvents(Customer customer) {
//        log.info("consumer consume the events {} ", customer.toString());
//    }
}
