package com.manu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manu.User;

public interface UserRepo extends JpaRepository<User, String> 
{
	
	

}
