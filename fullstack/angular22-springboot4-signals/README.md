# Full-Stack Angular 22 Signals & Spring Boot 4 WebFlux

## Overview
This is the companion code for the Webcodein article on building a reactive, full-stack application using Java 25, Spring Boot 4, R2DBC, and Angular 22 Signals.

## Requirements
- Java 25
- Maven 3.9+
- Node.js 22+ (for frontend)
- Docker & Docker Compose (for database)

## Running the Backend Locally
1. Start the PostgreSQL database:
   docker-compose up -d db
2. Run the Spring Boot application:
   mvn spring-boot:run

## Running the Tests
This project includes comprehensive Unit Tests using Mockito and Integration Tests using Testcontainers.
To run them (requires Docker to be running):
mvn verify

## Running the Entire Stack via Docker
docker-compose up --build
