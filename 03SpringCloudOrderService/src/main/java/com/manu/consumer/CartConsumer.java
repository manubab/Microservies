package com.manu.consumer;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class CartConsumer
{
	//@Autowired
	public DiscoveryClient client;
	
	public String getCartResponse()
	{	List<ServiceInstance> list=client.getInstances("CART-SERVICE");	
		ServiceInstance si=list.get(0);
		URI uri=si.getUri();
		String url=uri+"/cart/info";
		
		RestTemplate rt=new RestTemplate();
		
		ResponseEntity<String> response=rt.getForEntity(url, String.class);
		
		return response.getBody();
		
	}
	

}
