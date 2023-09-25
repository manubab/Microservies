package com.manu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.*;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
@Configuration
public class MyConfig
{
	public RouteLocator configRoutes(RouteLocatorBuilder builder)
	{
		
		
		
		return builder.routes()
				
				.route("cartRoutingid",r->r.path("/cart/**").uri("lb://CART-SERVICE"))
				.route("orderRoutingig",r->r.path("/order/**").uri("lb://ORDER-SERVICE"))
				
				.build();
	}
	

}
