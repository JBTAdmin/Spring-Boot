package com.javabeginnerstutorial.bootdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BootDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BootDemoApplication.class, args);
	}

	@Override
	public void run(String... strings) {

	}

	//TODO Better way of injecting bean
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		// Spring Boot no longer provide rest template.
		return builder.build();
	}
}
