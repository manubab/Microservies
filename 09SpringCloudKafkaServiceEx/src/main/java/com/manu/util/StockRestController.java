package com.manu.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manu.entity.StockInfo;

@RestController
@RequestMapping("/v1")
public class StockRestController
{
	
	@Autowired
	private ProduverService service;
	
	@Autowired
	private MessageStore store;
	
	
	@GetMapping("/send")
	public String readMessage(@RequestParam String code,
			@RequestParam Double cost
			)
	{
		
		StockInfo si=new StockInfo();
		si.setStdCode(code);
		si.setStkCost(cost);
		
		String message =JosnUtil.convertToString(si);
		service.sendMessage(message);
		
		return "SENT";
		
	}
	
	@GetMapping("/all")
	public List<StockInfo> fetchAll(){
		
		return store.getAll();
		
	}

}
