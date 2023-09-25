package com.manu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manu.User;
import com.manu.repo.UserRepo;

@Service
public class UserServiceimpl implements UserService {

	@Autowired
	UserRepo repo;

	public Optional<User> getUser(String userId) {

		return repo.findById(userId);
	}

	@Override
	public String saveUser(User user) {

		return repo.save(user).getUserId()+"user Saved ";
	}

	@Override
	public List<User> getAllUsers() {

		return repo.findAll();
	}

	@Override
	public String deleteUser(String userId) {
		
		 repo.deleteById(userId);
		 
		 return "Delete "+userId;
	}

}
