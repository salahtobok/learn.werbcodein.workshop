# Companion code for "Introduction to Domain-Driven Design with Jakarta EE 11"

This is the companion code for the Webcodein article: **Introduction to Domain-Driven Design with Jakarta EE 11: A Practical Guide**.

## Stack
- Java 25
- Spring Boot 4.0.0
- Jakarta EE 11 (Jakarta Data 1.0.1, Jakarta Persistence 3.2)
- Hibernate 7.1.0
- Testcontainers & PostgreSQL 16

## Overview
This project demonstrates the core concepts of Domain-Driven Design (DDD):
- **Aggregate Root:** `Order` (@Entity)
- **Entities:** `OrderItem` (@Entity)
- **Value Objects:** `Address` (@Embeddable)
- **Repositories:** `OrderRepository` (Jakarta Data `@Repository`)

## Prerequisites
- JDK 25 installed
- Docker installed and running (for Testcontainers)

## Running the Application

### 1. Build and Run Tests
The integration tests use Testcontainers to spin up an actual PostgreSQL 16 database and verify that the Jakarta Data repository correctly persists the Aggregate Root.

```bash
./mvnw clean verify
```
*(Note: If you are on Windows, use `mvnw.cmd clean verify`)*

### 2. Run Locally
You can run the application locally (it uses an in-memory H2 database by default for ease of testing):

```bash
./mvnw spring-boot:run
```

### 3. Build Docker Image
```bash
docker build -t ddd-jakarta-ee-demo .
docker run -p 8080:8080 ddd-jakarta-ee-demo
```
