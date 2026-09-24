# Hexagonal Architecture & DDD in Jakarta EE 11 with Spring Boot 4

This is the companion code for the article: [The Definitive Guide to Hexagonal Architecture & DDD in Jakarta EE 11](https://learn.webcodein.com/post/hexagonal-architecture-ddd-jakarta-ee-11).

## Tech Stack
- Java 25
- Spring Boot 4.0.0
- Jakarta EE 11 (CDI, JAX-RS, Jakarta Data 1.0)
- Hibernate 7.1
- PostgreSQL 16 (via Testcontainers)

## Running the application

### Locally with Maven
To run the application locally, you need Java 25 installed. Testcontainers will automatically spin up a PostgreSQL database.

```bash
./mvnw spring-boot:run
```

### With Docker
```bash
docker build -t hexagonal-ddd-jakarta-ee .
docker run -p 8080:8080 hexagonal-ddd-jakarta-ee
```

## Testing
Run the comprehensive test suite (Unit & Integration):
```bash
./mvnw clean verify
```
