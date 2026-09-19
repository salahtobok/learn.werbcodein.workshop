# learn.werbcodein.workshop

## Post <-> workshop map

| Domain | Post | Content path | Workshop |
|---|---|---|---|
| cloud-native | GraalVM Native Image with Spring Boot 4: Cloud-Native Java | `content/wordpress-export/cloud-native/graalvm-native-image-spring-boot` | [workshop/cloud-native/graalvm-native-image-spring-boot](https://github.com/salahtobok/learn.werbcodein.workshop/tree/main/cloud-native/graalvm-native-image-spring-boot) |
| persistence | Introducing Jakarta Data 1.0: The Powerful Enterprise Alternative to Spring Data | `content/wordpress-export/persistence/jakarta-data-1-0-vs-spring-data` | [workshop/persistence/jakarta-data-1-0-vs-spring-data](https://github.com/salahtobok/learn.werbcodein.workshop/tree/main/persistence/jakarta-data-1-0-vs-spring-data) |
| testing | Modern Local Development: Testcontainers & Docker Compose in Spring Boot 4 | `content/wordpress-export/testing/testcontainers-docker-compose-spring-boot-4` | [workshop/testing/testcontainers-docker-compose-spring-boot-4](https://github.com/salahtobok/learn.werbcodein.workshop/tree/main/testing/testcontainers-docker-compose-spring-boot-4) |
| security | Jakarta Security 4.0 vs Spring Security 7: The Ultimate 2026 Guide | `content/wordpress-export/security/jakarta-security-4-vs-spring-security-7` | [workshop/security/jakarta-security-4-vs-spring-security-7](https://github.com/salahtobok/learn.werbcodein.workshop/tree/main/security/jakarta-security-4-vs-spring-security-7) |
| architecture | Clean Architecture: Implementing Hexagonal (Ports & Adapters) in Spring Boot 4 | `content/wordpress-export/architecture/hexagonal-architecture-spring-boot-4` | [workshop/architecture/hexagonal-architecture-spring-boot-4](https://github.com/salahtobok/learn.werbcodein.workshop/tree/main/architecture/hexagonal-architecture-spring-boot-4) |
| persistence | Hibernate 7.0 & Spring Data JPA 4: The Best New Features | `content/wordpress-export/persistence/hibernate-7-spring-data-jpa-4` | [workshop/persistence/hibernate-7-spring-data-jpa-4](https://github.com/salahtobok/learn.werbcodein.workshop/tree/main/persistence/hibernate-7-spring-data-jpa-4) |

## CI
`.github/workflows/build.yml` builds every project with `mvn verify` (JDK 25, Docker available for the Testcontainers projects). Add a matrix entry when adding a project.
