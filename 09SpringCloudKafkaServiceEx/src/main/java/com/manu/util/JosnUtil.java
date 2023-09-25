package com.manu.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manu.entity.StockInfo;

public class JosnUtil 
{
	public static StockInfo convertToObj(String message)
	{
		
		
		  try {
	     
			  return	new ObjectMapper().readValue(message, StockInfo.class);
	
		  } catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	
	
	public static String convertToString(StockInfo si)
	{
		try {
			return new ObjectMapper().writeValueAsString(si);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
