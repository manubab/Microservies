package com.manu.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ConsumerService 
{
	@Autowired
	private  MessageStore store;
	
	@KafkaListener(topics = "${my.topic.name}",groupId = "abcd")
	public void readMessage(String message)
	{
		log.info("Message At Consumer :{}",message);
		store.add(message);
	}
	
	
	
	

}




