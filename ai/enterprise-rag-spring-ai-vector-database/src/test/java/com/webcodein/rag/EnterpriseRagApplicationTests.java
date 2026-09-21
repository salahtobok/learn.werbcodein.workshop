package com.webcodein.rag;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@Testcontainers
class EnterpriseRagApplicationTests {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> pgvector = new PostgreSQLContainer<>(DockerImageName.parse("pgvector/pgvector:pg16"));

    @Test
    void contextLoads() {
        // Verifies that the Spring Application Context loads successfully with PgVector.
    }
}
