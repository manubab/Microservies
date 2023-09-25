package com.manu.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
@RestController
@RequestMapping("/cart")
@RequestScope
public class CartRestController
{
	
	@Value("${my.app.title}")
	private String title;
	
	@Value("${server.port}")
	private String port;
	
	
	@GetMapping("/info")
	public ResponseEntity<String> showMessage()
	{
		
		return ResponseEntity.ok("Welcome to cart "+port+title );
		
	}

}
