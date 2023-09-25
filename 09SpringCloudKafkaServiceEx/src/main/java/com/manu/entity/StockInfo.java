package com.manu.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="tab")
public class StockInfo
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stkId;
	
	
	private String stdCode;
	
	private Double stkCost;
	
	
	

}
