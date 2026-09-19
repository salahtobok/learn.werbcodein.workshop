# Workshop: Clean Architecture: Implementing Hexagonal (Ports & Adapters) in Spring Boot 4

Companion code for the post `hexagonal-architecture-spring-boot-4`: a small bank-transfer use case.

## Structure
```
com.webcodein.bank
  domain/model        Account, AccountId, InsufficientFundsException (no framework code)
  domain/port/in      TransferMoneyUseCase        (inbound port)
  domain/port/out     LoadAccountPort, UpdateAccountStatePort (outbound ports)
  domain/service      TransferMoneyService        (use case implementation, plain Java)
  adapter/in/web      TransferController          (REST driving adapter)
  adapter/out/persistence  AccountPersistenceAdapter + JPA entity/repository/mapper
  configuration       DomainConfig                (wires the domain service as a bean)
```
The domain depends on nothing; adapters depend on the domain.

## Differences from the post
The post shows shortened snippets (missing imports, `AccountId`, `TransferRequest`, `AccountJpaEntity`, `AccountMapper`, `SpringDataAccountRepository`). This project contains the complete, compilable versions.

## Requirements
JDK 25, Maven 3.9+.

## Run
```bash
mvn verify            # domain test runs without Spring or a database
mvn spring-boot:run   # POST /api/transfers  {"source":1,"target":2,"amount":10}
```
There is no seed data, so a transfer returns an error until accounts with ids 1 and 2 exist.

Status: `mvn verify` passes (2 tests) on JDK 25, Maven 3.9.9, 2026-09-19. `mvn spring-boot:run` and the REST endpoint were not run.
