FROM eclipse-temurin:25-jdk-alpine AS builder
WORKDIR /build
COPY . /build
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:25-jre-alpine
WORKDIR /app
COPY --from=builder /build/target/virtual-threads-spring-boot-4-1.0.0-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
