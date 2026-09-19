package com.webcodein.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiController {

    private final ChatClient chatClient;

    public AiController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/api/chat")
    public String chat(@RequestParam(defaultValue = "Tell me a joke") String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }

    @GetMapping("/api/weather")
    public String weatherInfo(@RequestParam String city) {
        return chatClient.prompt()
                .user("What is the weather like in " + city + "?")
                .tools(WeatherService.class)
                .call()
                .content();
    }
}
