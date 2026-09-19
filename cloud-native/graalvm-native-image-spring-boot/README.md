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

Measured 2026-09-19 (Windows 11, Docker Desktop, 3 runs each): the native image in a container started in 0.14-0.17 s, the JVM jar on the host in 2.5-3.7 s (about 15-20x faster). The post quotes 0.045 s and 2.341 s; the JVM figure is in the same range, the native figure was not reproduced here (container on a Docker Desktop VM, not tuned).

Status: `mvn verify` passes (hints test) on JDK 25, Maven 3.9.9, 2026-09-19. `mvn -Pnative spring-boot:build-image` (buildpacks, BellSoft Liberica NIK 25) built a 236 MB image in 9m37s, and `GET /greet/Ada` returned the expected text. The `Dockerfile` (needs `./mvnw`) was not run.
