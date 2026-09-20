package com.webcodein.kotlin

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

data class MessageResponse(val text: String, val author: String = "WebCodein")

@RestController
@RequestMapping("/api/hello")
class HelloController {

    @GetMapping
    fun sayHello(): MessageResponse {
        return MessageResponse(text = "Hello from Kotlin and Spring Boot 4!")
    }
}
