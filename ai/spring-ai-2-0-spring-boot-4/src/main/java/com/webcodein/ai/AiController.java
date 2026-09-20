package com.webcodein.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;

@RestController
public class AiController {

    private final ChatClient chatClient;

    public AiController(ChatClient.Builder chatClientBuilder, ChatMemory chatMemory) {
        this.chatClient = chatClientBuilder
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();
    }

    @GetMapping("/api/chat")
    public String chat(
            @RequestParam(defaultValue = "Tell me a joke") String message,
            @RequestParam(defaultValue = "default-user") String chatId) {
        
        return chatClient.prompt()
                .user(message)
                .advisors(a -> a.param("chat_memory_conversation_id", chatId))
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

    public record Author(String name, String biography, List<String> famousBooks) {}

    @GetMapping("/api/author")
    public Author getAuthorInfo(@RequestParam(defaultValue = "J.R.R. Tolkien") String name) {
        return chatClient.prompt()
                .user("Give me a brief biography of " + name + " and list some famous books.")
                .call()
                .entity(Author.class);
    }
}
