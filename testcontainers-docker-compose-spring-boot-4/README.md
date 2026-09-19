# Modern Local Development: Testcontainers & Docker Compose in Spring Boot 4

Companion code for the post `testcontainers-docker-compose-spring-boot-4`.

## What is inside
- `compose.yaml`: Postgres and Redis. Spring Boot starts it automatically on `mvn spring-boot:run` (`spring-boot-docker-compose`).
- `EmployeeRepositoryIntegrationTest`: Testcontainers with `@ServiceConnection`.
- `AbstractIntegrationTest`: the singleton container pattern.
- `.github/workflows/ci.yml`: CI example from the post. GitHub only runs it from the repository root, so copy it to the root `.github/workflows/` to use it.

## Requirements
JDK 25, Maven 3.9+, a running Docker daemon.

## Run
```bash
mvn spring-boot:run   # local dev, containers managed via compose.yaml
mvn verify            # tests against real PostgreSQL via Testcontainers
```

Status: written but not yet built or run (no Docker verification).
