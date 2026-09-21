package com.webcodein.fullstack.reactive.controller;

import com.webcodein.fullstack.reactive.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
public class TaskControllerIntegrationTest {

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        // Need to convert jdbc URL to r2dbc URL for reactive context
        String r2dbcUrl = postgres.getJdbcUrl().replace("jdbc", "r2dbc");
        registry.add("spring.r2dbc.url", () -> r2dbcUrl);
        registry.add("spring.r2dbc.username", postgres::getUsername);
        registry.add("spring.r2dbc.password", postgres::getPassword);
    }

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreateAndGetTask() {
        Task task = new Task("Learn Angular Signals", false);

        webTestClient.post()
                .uri("/api/tasks")
                .body(Mono.just(task), Task.class)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Task.class)
                .value(response -> {
                    assertThat(response.getId()).isNotNull();
                    assertThat(response.getTitle()).isEqualTo("Learn Angular Signals");
                    assertThat(response.isCompleted()).isFalse();
                });

        webTestClient.get()
                .uri("/api/tasks")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Task.class)
                .hasSize(1);
    }
}
