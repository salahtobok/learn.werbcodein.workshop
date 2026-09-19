# Workshop: Hibernate 7.0 & Spring Data JPA 4: The Best New Features

Companion code for the post `hibernate-7-spring-data-jpa-4`.

## What is inside
- `product/`: entity with a JSON column (`@JdbcTypeCode(SqlTypes.JSON)`) and an HQL query inside it.
- `employee/`: HQL window function (`RANK() OVER ...`).
- `order/`: `@EntityGraph` fetching two collections together.
- `user/`: record projection (`UserSummary`).
- `ShopRepositoriesIntegrationTest`: one test per feature against real PostgreSQL (Testcontainers).

## Differences from the post
The post shows shortened snippets. Here the entities are complete, and the `User` entity is named `AppUser` (table `app_user`) because `user` is a reserved word in PostgreSQL.

- **JSON query:** `p.metadata.manufacturer` (as in the post) fails in Hibernate 7.1 with `UnknownPathException`. The working form is the HQL `json_value(p.metadata, '$.manufacturer')`, which is a tech-preview function and needs `hibernate.query.hql.json_functions_enabled=true` (set in `application.yml`). JSON mapping also needs Jackson 2 (`jackson-databind`) on the classpath.
- **`@EntityGraph` with two lists:** with `List` collections Hibernate 7.1 still throws `MultipleBagFetchException`, so `Order` uses `Set`.

## Requirements
JDK 25, Maven 3.9+, a running Docker daemon.

## Run
```bash
mvn verify
```

Status: `mvn verify` passes (4 tests, real PostgreSQL via Testcontainers) with Boot 4.0.0 on JDK 25, 2026-09-19.
