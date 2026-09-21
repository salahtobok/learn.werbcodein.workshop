# Zero-Trust Microservices with Spring Security 7 & eBPF Service Meshes

Companion project for the Webcodein article on building Zero-Trust microservices architectures using Java 25, Spring Boot 4.0, and ambient eBPF meshes without sidecar proxies.

## Stack
- Java 25
- Spring Boot 4.0.0
- Spring Security 7 (OAuth2 Resource Server)
- Spring Boot Test & MockMvc (Testing)

## Architecture Overview
This project simulates a secure microservice (Finance Service) deployed in an environment protected by an eBPF mesh (like Istio Ambient or Cilium).
- The **eBPF Mesh** handles Layer 4 Mutual TLS (mTLS) transparently across nodes.
- **Spring Security 7** handles Layer 7 authorization by inspecting the incoming JSON Web Token (JWT).

## Running the Application

### Local Development (Maven)
You can run the application directly using the Maven wrapper:
```bash
./mvnw spring-boot:run
```
*Note: Since this is a Resource Server expecting a valid JWT signature from an Identity Provider (like Keycloak), accessing the endpoints directly without a valid token will result in a 401 Unauthorized.*

### Running via Docker
To containerize the application:
```bash
docker build -t webcodein/zero-trust-finance:latest .
docker run -p 8080:8080 webcodein/zero-trust-finance:latest
```

## Testing
We use Spring Security Test with MockMvc to assert that fine-grained authorization rules (method-level `@PreAuthorize`) evaluate the JWT payload correctly without needing a real Identity Provider during unit testing.

To run the test suite:
```bash
./mvnw clean verify
```
