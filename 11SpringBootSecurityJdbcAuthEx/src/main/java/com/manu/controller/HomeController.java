package com.manu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController
{
	
	@GetMapping({"/home","/"})
	public String showHome()
	{
		return "home";
		
	}
	
	
	@GetMapping("/admin")
	public String showAdmin()
	{
		return "admin";
	}
	
	
	@GetMapping("/customer")
	public String showCustomer()
	{
		return "customer";
	}
	
	@GetMapping("/login")
	public String showLogin()
	{
		return "login";
		
	}
	
	@GetMapping("/hello")
	public String showHello()
	{
		return "hello";
	}
}
