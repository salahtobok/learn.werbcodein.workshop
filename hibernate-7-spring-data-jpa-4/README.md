# Workshop: Hibernate 7.0 & Spring Data JPA 4: The Best New Features

Companion code for the post `hibernate-7-spring-data-jpa-4`.

## What is inside
- `product/`: entity with a JSON column (`@JdbcTypeCode(SqlTypes.JSON)`) and an HQL query inside it.
- `employee/`: HQL window function (`RANK() OVER ...`).
- `order/`: `@EntityGraph` fetching two lists without `MultipleBagFetchException`.
- `user/`: record projection (`UserSummary`).
- `ShopRepositoriesIntegrationTest`: one test per feature against real PostgreSQL (Testcontainers).

## Differences from the post
The post shows shortened snippets. Here the entities are complete, and the `User` entity is named `AppUser` (table `app_user`) because `user` is a reserved word in PostgreSQL.

## Requirements
JDK 25, Maven 3.9+, a running Docker daemon.

## Run
```bash
mvn verify
```

Status: written but not yet built or run. Whether Boot 4.0.0 / Hibernate 7 accept the JSON path query and the record projection exactly as in the post is unverified.
