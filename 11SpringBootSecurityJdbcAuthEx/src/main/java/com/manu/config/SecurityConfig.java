package com.manu.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
{
	
	@Bean	
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	public SecurityFilterChain configureAuth(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests(request ->request.requestMatchers("/","/home").permitAll()
				.requestMatchers("/admin").hasAuthority("ADMIN")
				.requestMatchers("/customer").hasAuthority("CUSTOMER")
				.anyRequest().authenticated())
		.formLogin(
				form ->form.loginPage("/login").permitAll()
				.defaultSuccessUrl("/hello",true)
				)
		.logout(logout ->logout.permitAll());
		
		return http.build();
		
	}
	
	@Bean
	public UserDetailsService userDetails(DataSource datasource)
	{
		
		UserDetails user1=User.withUsername("sam").password("$2a$10$w9YJDSCFlPjTWRg2XFq9M.AICxzmvnn51TX0XjgZEwajPjM7pFMhm")
				.authorities("ADMIN").build();
		
		UserDetails user2=User.withUsername("ram").password("$2a$10$k30v9zLInIIfY8tXLvTeCu6X0mZwfOf0s7kp2A9kwc.H1U4Aks8gK").authorities("CUSTOMER").build();
	
		JdbcUserDetailsManager users= new JdbcUserDetailsManager();
		
		users.createUser(user1);
		users.createUser(user2);
		
		return users;
	}

}
