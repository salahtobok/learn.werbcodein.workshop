# Stage 1: Build the native image
FROM ghcr.io/graalvm/native-image-community:25 AS builder
WORKDIR /app
COPY . .
RUN ./mvnw -Pnative native:compile -DskipTests

# Stage 2: Minimal runtime image
FROM gcr.io/distroless/base-debian12
# The native binary links against zlib, which distroless/base does not ship
COPY --from=builder /usr/lib64/libz.so.1 /lib/x86_64-linux-gnu/libz.so.1
COPY --from=builder /app/target/native-demo /app/native-demo
EXPOSE 8080
ENTRYPOINT ["/app/native-demo"]
