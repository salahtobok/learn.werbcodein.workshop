package com.webcodein.cicd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

@RestController
public class AppController {

    @Value("${app.version:1.0.0}")
    private String version;

    @GetMapping("/api/status")
    public Map<String, String> getStatus() {
        String hostname = "unknown";
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            // Ignore
        }
        
        return Map.of(
            "status", "UP",
            "version", version,
            "hostname", hostname,
            "message", "Zero-downtime deployment successful!"
        );
    }
}
