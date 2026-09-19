package com.webcodein.nativedemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GreetingController {

    @GetMapping("/greet/{name}")
    String greet(@PathVariable String name) {
        return "Hello, " + name + "! This response comes from a native image.";
    }
}
