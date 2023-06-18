package com.han.atm;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class AtmBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmBatchApplication.class, args);
	}
}
