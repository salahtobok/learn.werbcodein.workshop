# DDD Masterclass - Java 25 & Spring Boot 4

This is the companion code for the Webcodein article: **Domain-Driven Design (DDD) Masterclass: The Ultimate Java Developer Guide**.

It demonstrates:
- A pure Domain Model (Entities, Value Objects, Aggregates) free of external dependencies.
- A Hexagonal Architecture applying Application Services to orchestrate use cases.
- Integration testing with Testcontainers.

## Requirements
- Java 25
- Docker (for Testcontainers and docker-compose)
- Maven 3.9+

## Running the Tests
To build the project and run the unit & integration tests (requires Docker to be running):
```bash
./mvnw clean verify
```

## Running Locally

### Option 1: Docker Compose (Recommended)
You can run the entire application along with its PostgreSQL database using Docker Compose:
```bash
docker-compose up --build
```
The application will start on `http://localhost:8080`.

### Option 2: Spring Boot Run
Start a local PostgreSQL database (e.g. via `docker-compose up postgres`), then run:
```bash
./mvnw spring-boot:run
```

## API Endpoints

**1. Create Order**
```bash
curl -X POST "http://localhost:8080/api/orders?customerId=123e4567-e89b-12d3-a456-426614174000"
```

**2. Add Item to Order**
```bash
curl -X POST "http://localhost:8080/api/orders/{orderId}/items?productId=987e6543-e21b-34d5-c678-426614174999&quantity=2&price=99.99"
```

**3. Confirm Order**
```bash
curl -X POST "http://localhost:8080/api/orders/{orderId}/confirm"
```
