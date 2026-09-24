# learn.werbcodein.workshop

## Post <-> workshop map

| Domain | Post | Content path | Workshop |
|---|---|---|---|
| cloud-native | GraalVM Native Image with Spring Boot 4: Cloud-Native Java | `content/wordpress-export/cloud-native/graalvm-native-image-spring-boot` | [workshop/cloud-native/graalvm-native-image-spring-boot](https://github.com/salahtobok/learn.werbcodein.workshop/tree/main/cloud-native/graalvm-native-image-spring-boot) |
| persistence | Introducing Jakarta Data 1.0: The Powerful Enterprise Alternative to Spring Data | `content/wordpress-export/persistence/jakarta-data-1-0-vs-spring-data` | [workshop/persistence/jakarta-data-1-0-vs-spring-data](https://github.com/salahtobok/learn.werbcodein.workshop/tree/main/persistence/jakarta-data-1-0-vs-spring-data) |
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
| ai | Spring AI 2.0: The Complete Guide to AI Integration in Spring Boot 4 | `content/wordpress-export/ai/spring-ai-2-0-spring-boot-4` | [workshop/ai/spring-ai-2-0-spring-boot-4](https://github.com/salahtobok/learn.werbcodein.workshop/tree/main/ai/spring-ai-2-0-spring-boot-4) |
| kotlin | Kotlin Backend Development with Spring Boot 4 | `content/wordpress-export/kotlin/kotlin-spring-boot-4-backend-guide` | [workshop/kotlin/kotlin-spring-boot-4-backend-guide](https://github.com/salahtobok/learn.werbcodein.workshop/tree/main/kotlin/kotlin-spring-boot-4-backend-guide) |
| cloud-native | CI/CD DevOps: Zero-Downtime Deployments with GitHub Actions, Terraform, and Docker Swarm | `content/wordpress-export/cloud-native/cicd-github-actions-terraform-swarm` | [workshop/cloud-native/cicd-github-actions-terraform-swarm](https://github.com/salahtobok/learn.werbcodein.workshop/tree/main/cloud-native/cicd-github-actions-terraform-swarm) |
| java-core | Project Valhalla: Value Types in Java 25 | `content/wordpress-export/java-core/project-valhalla-value-types-java-25` | [workshop/java-core/project-valhalla-value-types-java-25](https://github.com/salahtobok/learn.werbcodein.workshop/tree/main/java-core/project-valhalla-value-types-java-25) |
| architecture | Event-Driven Microservices in Java 25: Apache Kafka & Spring Boot 4 | `content/wordpress-export/architecture/event-driven-kafka-spring-boot-4` | [workshop/architecture/event-driven-kafka-spring-boot-4](https://github.com/salahtobok/learn.werbcodein.workshop/tree/main/architecture/event-driven-kafka-spring-boot-4) |
| observability | Observability & Distributed Tracing in Spring Boot 4 | `content/wordpress-export/observability/opentelemetry-grafana-spring-boot-4` | [workshop/observability/opentelemetry-grafana-spring-boot-4](https://github.com/salahtobok/learn.werbcodein.workshop/tree/main/observability/opentelemetry-grafana-spring-boot-4) |
| java-core | Java 25 Virtual Threads in Spring Boot 4: High-Concurrency APIs | `content/wordpress-export/java-core/virtual-threads-spring-boot-4` | [workshop/java-core/virtual-threads-spring-boot-4](https://github.com/salahtobok/learn.werbcodein.workshop/tree/main/java-core/virtual-threads-spring-boot-4) |
| architecture | The Definitive Guide to Hexagonal Architecture & DDD in Jakarta EE 11 | `content/wordpress-export/architecture/hexagonal-architecture-ddd-jakarta-ee-11` | [workshop/architecture/hexagonal-architecture-ddd-jakarta-ee-11](https://github.com/salahtobok/learn.werbcodein.workshop/tree/main/architecture/hexagonal-architecture-ddd-jakarta-ee-11) |
| architecture | Introduction to Domain-Driven Design with Jakarta EE 11: A Practical Guide | `content/wordpress-export/architecture/introduction-to-ddd-jakarta-ee-11` | [workshop/architecture/introduction-to-ddd-jakarta-ee-11](https://github.com/salahtobok/learn.werbcodein.workshop/tree/main/architecture/introduction-to-ddd-jakarta-ee-11) |

| architecture | Practical Domain-Driven Design with Jakarta EE 11 | `content/wordpress-export/architecture/practical-ddd-jakarta-ee` | [workshop/architecture/practical-ddd-jakarta-ee](https://github.com/salahtobok/learn.werbcodein.workshop/tree/main/architecture/practical-ddd-jakarta-ee) |

## CI
`.github/workflows/build.yml` builds every project with `mvn verify` (JDK 25, Docker available for the Testcontainers projects). Add a matrix entry when adding a project.
