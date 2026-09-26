# Bounded Context DDD Explained

This workshop project demonstrates a simple modular monolith using Domain-Driven Design (DDD) principles. It is structured into multiple bounded contexts.

## Bounded Contexts included

* **Catalog**: Manages products.
* **Order**: Manages customer orders.
* **Shipping**: (Placeholder for logistics)
* **Billing**: (Placeholder for payments)

## Running the application

```bash
docker-compose up -d
./mvnw spring-boot:run
```

## Running tests
```bash
./mvnw clean verify
```
