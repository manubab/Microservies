package com.manu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manu.entity.StockInfo;

public interface StackInfoRepository extends JpaRepository<StockInfo, Integer> 
{
	
	

}
