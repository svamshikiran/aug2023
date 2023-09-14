package com.example.aug2023.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloControllerTest {

    @Autowired
    HelloController helloController;

    @Test
    void sayHello() {

        String expectedMessage = "WELCOME TO THE SPRINGBOOT FRAMEWORK";

        String actualMessage = helloController.sayHello();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSayHello() {
    }

    @Test
    void sayHelloWithParameter() {

        String input = "TEST";

        String responseMessage = helloController.sayHelloWithParameter(input);
        assertNotNull(responseMessage);
        assertTrue(responseMessage.contains(input));
    }

    @Test
    void postMessage() {
    }
}