package com.manu.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestSenderRunner implements CommandLineRunner {

	
	
	@Autowired
	private ProducerService service;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		service.sendMessage("Hello manu "+new Date());
		

	}

}
