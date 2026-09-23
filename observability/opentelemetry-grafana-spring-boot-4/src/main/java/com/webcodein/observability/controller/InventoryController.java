package com.webcodein.observability.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private static final Logger log = LoggerFactory.getLogger(InventoryController.class);
    private final Random random = new Random();

    @GetMapping("/{id}")
    public String checkInventory(@PathVariable String id) throws InterruptedException {
        log.info("Checking inventory for item: {}", id);
        
        // Simulate processing delay to show up in trace waterfall
        Thread.sleep(random.nextInt(100) + 50);
        
        log.info("Inventory check complete for item: {}", id);
        return "AVAILABLE";
    }
}
