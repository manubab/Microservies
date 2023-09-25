package com.manu;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User
{
	@Id
	private String userId;
	
	private String userName;
	
	private String userAddress;
	
	private String userBuyProducts;

}
