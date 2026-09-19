# Modern Local Development: Testcontainers & Docker Compose in Spring Boot 4

Companion code for the post `testcontainers-docker-compose-spring-boot-4`.

## What is inside
- `compose.yaml`: Postgres and Redis. Spring Boot starts it automatically on `mvn spring-boot:run` (`spring-boot-docker-compose`).
- `EmployeeRepositoryIntegrationTest`: Testcontainers with `@ServiceConnection`.
- `AbstractIntegrationTest`: the singleton container pattern.
- CI: the workshop repo root workflow `.github/workflows/build.yml` builds this project (GitHub only runs workflows from the repo root). The workflow shown in the post is the same idea: JDK 25 plus `mvn -B verify`, with Docker already available on `ubuntu-latest`.

## Requirements
JDK 25, Maven 3.9+, a running Docker daemon.

## Run
```bash
mvn spring-boot:run   # local dev, containers managed via compose.yaml
mvn verify            # tests against real PostgreSQL via Testcontainers
```

Status: `mvn verify` passes (2 tests, real PostgreSQL via Testcontainers) on JDK 25, Maven 3.9.9, Docker Desktop, 2026-09-19. `mvn spring-boot:run` with `compose.yaml` was not run.
