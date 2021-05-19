package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@SpringBootApplication
@RestController
public class DemoApplication {
	
	

	private final Counter counter;
	@Autowired
	public DemoApplication(MeterRegistry registry) {
	this.counter = registry.counter("recieved.count");
	}

	@Value("${message}")  //spel spring expr lang
	private String message;
	
	@GetMapping("/message")
	public String hello() {
	this.counter.increment();
	return message;
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Hi Asha");
	}

}
