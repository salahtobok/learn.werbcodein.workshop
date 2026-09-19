# Workshop: Introducing Jakarta Data 1.0: The Powerful Enterprise Alternative to Spring Data

Companion code for the post `jakarta-data-1-0-vs-spring-data`.

## What is inside
- `EmployeeRepository`: `CrudRepository`, a parameter-based `@Find` query and a custom `@Query`.
- `ProductRepository`: pagination with `Page` / `PageRequest`.
- `JakartaDataRepositoriesTest`: runs both against in-memory H2, using the implementations Hibernate generates at compile time (`EmployeeRepository_`, `ProductRepository_` via `hibernate-processor`).

No Spring is involved: the point of the post is that Jakarta Data is a standard API, and Hibernate is one implementation. In a Jakarta EE runtime the repository is injected with `@Inject` instead of being constructed by hand.

## Differences from the post
- The post sorts with `PageRequest.of(1, 20).sortBy(Sort.asc("price"))`. Jakarta Data 1.0 takes the sort as a separate `Order` parameter and builds pages with `PageRequest.ofPage(1).size(20)`, so this code uses that form.
- The post shows a derived query by method name (`findByDepartmentAndIsActiveTrue`). Hibernate's Jakarta Data implementation does not implement query-by-method-name (the processor reports "repository method cannot be implemented"), so this code uses `@Find` with `@By` parameters instead. The entity property is `active` (was `isActive`).
- Entities are added (`Employee`, `Product`); the post does not show them.

## Requirements
JDK 21+, Maven 3.9+. No Docker needed.

## Run
```bash
mvn verify
```

Status: `mvn verify` passes (2 tests, H2) with Hibernate 7.1.0 and Jakarta Data 1.0.1 on JDK 25, 2026-09-19.
