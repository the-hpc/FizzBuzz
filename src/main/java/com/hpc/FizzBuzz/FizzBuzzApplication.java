package com.hpc.FizzBuzz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FizzBuzzApplication {

	private static final Logger logger = LoggerFactory.getLogger(FizzBuzzApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FizzBuzzApplication.class, args);
		logger.info("FizzBuzz application started successfully.");
	}
}