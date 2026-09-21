package com.webcodein.valhalla;

import com.webcodein.valhalla.entity.BenchmarkRun;
import com.webcodein.valhalla.repository.BenchmarkRunRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class ValhallaApplicationTests {

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Autowired
    private BenchmarkRunRepository repository;

    @Test
    void contextLoadsAndCanSaveRun() {
        BenchmarkRun run = new BenchmarkRun("ValueTypeTest", 15000L);
        BenchmarkRun saved = repository.save(run);
        
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getName()).isEqualTo("ValueTypeTest");
        
        assertThat(repository.count()).isGreaterThan(0);
    }
}
