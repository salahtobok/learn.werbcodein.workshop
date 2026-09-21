# Project Valhalla Performance Benchmark (Workshop)

Companion code for the article **Project Valhalla Value Types in Java 25: A Performance Deep Dive**.

## Prerequisites
- Java 25 (with `--enable-preview`)
- Maven 3.9+
- Docker (for Testcontainers during tests)

## Building the Project
Use the Maven wrapper to build the project and run the tests:
```bash
./mvnw clean verify
```

## Running the Application Locally
To run the Spring Boot application locally, you must first start the PostgreSQL database via Docker Compose:
```bash
docker-compose up -d
./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="--enable-preview"
```
