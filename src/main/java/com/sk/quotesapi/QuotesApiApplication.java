package com.sk.quotesapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuotesApiApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(QuotesApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
