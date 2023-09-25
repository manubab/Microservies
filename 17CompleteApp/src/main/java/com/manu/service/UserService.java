package com.manu.service;

import java.util.List;
import java.util.Optional;

import com.manu.User;

public interface UserService 
{
	
	public Optional<User> getUser(String userId);
	
	public String saveUser(User user);
	
	
	public List<User> getAllUsers();
	
	public String deleteUser(String userId);

}
