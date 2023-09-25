package com.manu.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GetTestRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		// /save/user

		String url = "http://localhost:9090/user/save/user";

		String userId;

		String userName;

		String userAddress;

		String userBuyProducts;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);



		
		String body = "{\"userId\" : 101,\"userName\" : \"ABC\", \"userAddress\":\"kuronnl\", \"userBuyProducts\":\"coke\"}";
		
		
		HttpEntity<String> requestEntity= new HttpEntity<>(body,headers);
		
		RestTemplate template= new RestTemplate();
		
		
		ResponseEntity<String> abc=template.exchange(url,HttpMethod.POST,requestEntity,String.class );
		
		
		System.out.println(abc.getBody());
		
	}

}
