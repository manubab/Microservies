package com.manu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class AppMailSender 
{
	@Autowired
	private JavaMailSender sender;
	
	
	@Value("")
	private String from;

}
