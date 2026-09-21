package com.webcodein.security.zerotrust.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/public/hello")
    public Map<String, String> publicHello() {
        return Map.of("message", "Hello, this is a public endpoint.");
    }

    @GetMapping("/secure/hello")
    public Map<String, String> secureHello(@AuthenticationPrincipal Jwt jwt) {
        String username = jwt.getClaimAsString("preferred_username");
        return Map.of("message", "Hello " + username + ", you are authenticated via Zero-Trust OAuth2.");
    }

    @GetMapping("/admin/dashboard")
    public Map<String, String> adminDashboard() {
        return Map.of("message", "Welcome to the Admin Dashboard.");
    }
}
