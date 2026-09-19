# Workshop: GraalVM Native Image with Spring Boot 4: Cloud-Native Java

Companion code for the post `graalvm-native-image-spring-boot`.

## What is inside
- `NativeDemoApplication` + `GreetingController`: the demo endpoint `GET /greet/{name}`.
- `MyHints` + `MyDynamicClass`: custom runtime hints (reflection and a resource pattern), registered with `@ImportRuntimeHints`.
- `MyHintsTest`: verifies the hints without building a native image.
- `Dockerfile`: multi-stage native build from the post.

## Requirements
JDK 25 (GraalVM for the native build), Maven 3.9+, Docker for `build-image` and the Dockerfile.

## Run
```bash
mvn verify                              # JVM build + hints test
mvn -Pnative native:compile             # native binary at target/native-demo
mvn -Pnative spring-boot:build-image    # native container image via buildpacks
java -jar target/native-demo-0.0.1-SNAPSHOT.jar   # JVM comparison
```
The post uses `./mvnw`; this folder has no Maven wrapper. Generate one with `mvn wrapper:wrapper` before using the `Dockerfile`.

Startup times in the post (0.045s native vs 2.341s JVM) were not measured here.

Status: written but not yet built or run.
