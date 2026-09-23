# Observability & Distributed Tracing in Spring Boot 4

This is the companion workshop repository for the Webcodein article on Observability with OpenTelemetry, Grafana, Prometheus, and Tempo using Java 25 and Spring Boot 4.0.0.

## Prerequisites
- Java 25
- Docker & Docker Compose

## Running Locally

1. Start the observability stack (Prometheus, Tempo, Grafana) via Docker Compose:
   ```bash
   docker compose up -d
   ```
2. Build and run the Spring Boot application:
   ```bash
   ./mvnw spring-boot:run
   ```
3. Generate some traffic by opening your browser or using curl:
   ```bash
   curl http://localhost:8080/api/orders/123
   ```
4. Access Grafana to view metrics and traces:
   - URL: `http://localhost:3000`
   - Explore Prometheus metrics (e.g., `http_server_requests_seconds_count`)
   - Explore Tempo distributed traces by querying the `observability-demo` service.
