package com.sk.quotesapi;

import com.sk.quotesapi.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuotesApiApplicationTests {

	@Autowired
	private UserController userController;

	@Test
	void contextLoads() {
	}

	
}
