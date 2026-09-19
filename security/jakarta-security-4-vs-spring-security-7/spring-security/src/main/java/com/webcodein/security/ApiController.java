package com.webcodein.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ApiController {

    @GetMapping("/api/public/hello")
    String publicHello() {
        return "Hello, everyone";
    }

    @GetMapping("/api/admin")
    String adminData() {
        return "Top Secret Enterprise Data";
    }
}
