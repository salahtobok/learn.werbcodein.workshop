# Stage 1: Build the native image
FROM ghcr.io/graalvm/native-image-community:25 AS builder
WORKDIR /app
COPY . .
RUN ./mvnw -Pnative native:compile -DskipTests

# Stage 2: Minimal runtime image
FROM gcr.io/distroless/base-debian12
COPY --from=builder /app/target/native-demo /app/native-demo
EXPOSE 8080
ENTRYPOINT ["/app/native-demo"]
