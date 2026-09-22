# CQRS and Event Sourcing with Kafka

A companion project demonstrating Command Query Responsibility Segregation (CQRS) using Spring Boot 4, Java 25, Apache Kafka, and PostgreSQL.

## How to run locally

### 1. Start Infrastructure
Start the required PostgreSQL and Redpanda (Kafka API compatible) containers:
```bash
docker-compose up -d
```

### 2. Run the application
```bash
./mvnw spring-boot:run
```

### 3. Test the API

**Command (Write):**
```bash
curl -X POST http://localhost:8080/api/orders \
  -H "Content-Type: application/json" \
  -d '{"customerId":"CUST123", "totalAmount": 250.50}'
```

**Query (Read):**
```bash
curl http://localhost:8080/api/orders/summary/CUST123
```

## Running the Integration Tests
The tests use Testcontainers to spin up ephemeral Kafka and PostgreSQL instances.
```bash
./mvnw clean verify
```
