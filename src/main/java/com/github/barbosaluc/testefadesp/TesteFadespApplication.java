package com.github.barbosaluc.testefadesp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TesteFadespApplication implements CommandLineRunner {

	 private static final Logger logger = LoggerFactory.getLogger(TesteFadespApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(TesteFadespApplication.class, args);
		System.out.println("A aplicação iniciada com sucesso!");
	}

	@Override
	public void run(String...args) throws Exception {
		logger.info("A aplicação iniciada com sucesso!");
	}	
}
