package com.webcodein.rag.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.rag.advisor.RetrievalAugmentationAdvisor;
import org.springframework.ai.rag.retrieval.search.VectorStoreDocumentRetriever;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder chatClientBuilder, VectorStore vectorStore) {
        this.chatClient = chatClientBuilder
                .defaultAdvisors(RetrievalAugmentationAdvisor.builder()
                        .documentRetriever(VectorStoreDocumentRetriever.builder()
                                .vectorStore(vectorStore)
                                .topK(3)
                                .build())
                        .build())
                .build();
    }

    public String chat(String query) {
        return chatClient.prompt()
                .user(query)
                .call()
                .content();
    }
}
