package com.manu.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manu.entity.StockInfo;
import com.manu.repo.StackInfoRepository;

@Component
public class MessageStore
{
	@Autowired
	private StackInfoRepository repo;
	
	public void add(String message)
	{
		StockInfo si=JosnUtil.convertToObj(message);
		repo.save(si);
	}
	
	public List<StockInfo> getAll()
	{
		return repo.findAll();
	}

}


