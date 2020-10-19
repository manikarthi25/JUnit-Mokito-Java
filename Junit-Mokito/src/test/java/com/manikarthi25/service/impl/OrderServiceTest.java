package com.manikarthi25.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceTest {

	@Autowired
	private OrderService junitService;

	@Test
	public void testGetWelcomeMesage() {

		String name = "mani";
		String actualMeaage = junitService.getWelcomeMesage(name);
		String expectedMessage = "welcome mani";

		assertNotNull(actualMeaage); 
		assertEquals(expectedMessage, actualMeaage);
	}
	
	//@Test(IllegalArgumentException.class) - JUnit 4
	@Test //JUnit 5
	public void testGetWelcomeMesage_ThorwAnException_When_NameIsNull() {
		String name = null;
		Assertions.assertThrows(IllegalArgumentException.class, () -> junitService.getWelcomeMesage(name));
	}
	
	@Test 
	public void testGetWelcomeMesage_ThorwAnException_When_NameIsEmpty() {
		String name = "";
		Assertions.assertThrows(IllegalArgumentException.class, () -> junitService.getWelcomeMesage(name));
	}

}
