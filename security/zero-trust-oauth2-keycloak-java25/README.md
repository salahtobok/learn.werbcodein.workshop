# Zero-Trust OAuth2 with Keycloak (Java 25 / Spring Boot 4)

This repository contains the companion workshop code for the Webcodein article: **Mastering Zero-Trust Architecture**.

## Prerequisites
- Docker & Docker Compose
- Maven 3.9+
- Java 25 (or Java 21 LTS)

## Running Guide

### 1. Start Keycloak

We use Docker Compose to start a pre-configured Keycloak instance.

```bash
docker-compose up -d keycloak
```

This will start Keycloak on `http://localhost:8080`.
- Admin console: `http://localhost:8080/admin` (admin/admin)
- It automatically imports `webcodein-realm` and a test user (`testuser` / `password`).

### 2. Start the Spring Boot App

You can run the app locally using Maven:

```bash
mvn spring-boot:run
```

Alternatively, you can run the entire stack (App + Keycloak) using Docker Compose:

```bash
docker-compose up -d
```

The app will be available on `http://localhost:8081`.

### 3. Testing the Zero-Trust API

**Step A: Test Public Endpoint**
```bash
curl http://localhost:8081/api/public/hello
```
Expected: `{"message": "Hello, this is a public endpoint."}`

**Step B: Test Secure Endpoint (Without Token)**
```bash
curl http://localhost:8081/api/secure/hello
```
Expected: `401 Unauthorized`

**Step C: Get a Token from Keycloak**
```bash
TOKEN=$(curl -s -X POST "http://localhost:8080/realms/webcodein-realm/protocol/openid-connect/token" \
 -H "Content-Type: application/x-www-form-urlencoded" \
 -d "username=testuser" \
 -d "password=password" \
 -d "grant_type=password" \
 -d "client_id=spring-boot-client" | jq -r .access_token)
```

**Step D: Access Secure Endpoint**
```bash
curl -H "Authorization: Bearer $TOKEN" http://localhost:8081/api/secure/hello
```
Expected: `{"message": "Hello testuser, you are authenticated via Zero-Trust OAuth2."}`

## Clean Up
To stop and remove the containers:
```bash
docker-compose down
```
