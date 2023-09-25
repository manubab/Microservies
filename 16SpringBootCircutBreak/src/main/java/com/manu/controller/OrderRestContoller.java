package com.manu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class OrderRestContoller {
  
	private static final String ORDER_SERVICE="orderService";
	
	@GetMapping("/order")
	@CircuitBreaker(name="ORDER_SERVICE",fallbackMethod="orderFallback")
	
	public ResponseEntity<String> createOrder()
	{
	String response=	new RestTemplate().getForObject("http://localhost:8081/item", String.class);
		return new ResponseEntity<String>(response ,HttpStatus.OK);
	}
	
	public ResponseEntity<String> orderFallBack(Exception e)
	{
		return new ResponseEntity<String>("Service is down ! try after some time",HttpStatus.OK);
	}
}
