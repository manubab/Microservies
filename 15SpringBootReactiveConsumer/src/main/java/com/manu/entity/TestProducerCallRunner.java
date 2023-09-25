package com.manu.entity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@Component
public class TestProducerCallRunner implements CommandLineRunner {

	
	public void run(String... args) throws Exception {


		WebClient client=WebClient.create("http://localhost:9090/student");
		
		/*Mono<Student> result=
				client.post()
				.uri("/create")
				.body(Mono.just(new Student("AA254","SAM",300.0)),Student.class)
				.retrieve()
				.bodyToMono(Student.class);
		
		System.out.println("From Consumer ------- > ");
		
	result.subscribe(System.out::println);
		*/
		
		/*
		 * Mono<Student> result= client.get().uri("/fetch/AA254").retrieve()
		 * .bodyToMono(Student.class);
		 * 
		 * result.subscribe(System.out::println);
		 */
		
		
		
		
		Flux<Student> flux= client.get().uri("/all")
				.retrieve()
				.bodyToFlux(Student.class);
		
		flux.doOnNext(System.out::println).blockLast();
	}

}
