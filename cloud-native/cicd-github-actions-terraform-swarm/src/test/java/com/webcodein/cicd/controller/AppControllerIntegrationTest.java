package com.webcodein.cicd.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AppControllerIntegrationTest {

    @Autowired
    private AppController appController;

    @Test
    public void testGetStatus() {
        Map<String, String> response = appController.getStatus();
        assertNotNull(response);
        assertEquals("UP", response.get("status"));
        assertEquals("Zero-downtime deployment successful!", response.get("message"));
    }
}
