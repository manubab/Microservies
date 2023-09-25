package com.manu.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("CART-SERVICE")
public interface CartConsumerFeign 
{
	@GetMapping("/cart/info")
	public ResponseEntity<String> showMessage();

}
