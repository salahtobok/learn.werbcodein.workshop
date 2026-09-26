# DDD vs CRUD: A Visual Guide for Java Developers

This repository contains the companion code for the article **"DDD vs. CRUD: A Visual Guide for Java Developers"**.
It demonstrates the exact same domain (Order Management) implemented twice:
- `com.webcodein.workshop.crud` - Standard CRUD architecture
- `com.webcodein.workshop.ddd` - Domain-Driven Design architecture

## Prerequisites
- Java 25
- Maven
- Docker & Docker Compose (for the PostgreSQL database)

## Running the Application
1. Start the database:
   ```bash
   docker-compose up -d
   ```
2. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

## Running Tests
Run the tests using Maven:
```bash
./mvnw clean verify
```
