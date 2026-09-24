# DDD with Jakarta EE 11 Example

This is the companion code for the article **Introduction to Domain-Driven Design (DDD) with Jakarta EE: From Concepts to a Real Application**.

## Tech Stack
- Java 25
- Spring Boot 4.0.0
- Jakarta REST (Jersey)
- Jakarta Data 1.0.1
- Hibernate 7.1.0
- PostgreSQL 16 (Testcontainers)

## Running the Application

### 1. Build the project
```bash
./mvnw clean verify
```

### 2. Run with Docker Compose
Start the database:
```bash
docker-compose up -d
```

### 3. Run the application
```bash
./mvnw spring-boot:run
```

### 4. Test the REST API
Create a document:
```bash
curl -X POST http://localhost:8080/documents \
     -H "Content-Type: application/json" \
     -d '{"title":"Test Document"}'
```

Publish the document (replace `<id>` with the UUID from the previous response):
```bash
curl -X POST http://localhost:8080/documents/<id>/publish
```
