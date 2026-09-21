package com.webcodein.rag.controller;

import com.webcodein.rag.service.ChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RagController {
    private final ChatService chatService;

    public RagController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/chat")
    public String chat(@RequestParam String query) {
        return chatService.chat(query);
    }
}
