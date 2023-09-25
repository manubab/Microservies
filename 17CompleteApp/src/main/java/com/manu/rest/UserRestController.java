package com.manu.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manu.User;
import com.manu.service.UserServiceimpl;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	UserServiceimpl service;

	@GetMapping("/showuser/{userId}")
	public Optional<User> getUser(@PathVariable String userId) {
		return service.getUser(userId);
	}

	@PostMapping("/save/user")
	public String saveUser(@RequestBody User user) {

		return service.saveUser(user);
	}

	@GetMapping("/all")
	public List<User> getAll() {

		return service.getAllUsers();
	}

	@DeleteMapping("/delete/{userId}")
	public String deleteById(@PathVariable String userId) {
		return service.deleteUser(userId);
	}

}
