# Virtual Threads in Spring Boot 4 Workshop

This repository contains the companion code for the Webcodein article:
[**Java 25 Virtual Threads in Spring Boot 4: High-Concurrency APIs**](https://learn.webcodein.com/post/high-concurrency-apis-java-25-virtual-threads-spring-boot-4).

It demonstrates how to leverage **Java 25 Virtual Threads** within **Spring Boot 4.0.0** to handle thousands of concurrent blocking operations without using Reactive programming (WebFlux).

## Features
- **Java 25** Virtual Threads enabled (`spring.threads.virtual.enabled=true`).
- **Spring Boot 4.0.0** web server simulating a slow blocking database call.
- Returns the execution thread name to prove it runs on a `VirtualThread`.

## Running the Application Locally

1. **Clone the repository and navigate to the project directory:**
   ```bash
   git clone https://github.com/salahtobok/learn.webcodein.com.git
   cd learn.webcodein.com/workshop/java-core/virtual-threads-spring-boot-4
   ```

2. **Build and test the project:**
   ```bash
   ./mvnw clean verify
   ```

3. **Run the application:**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Test the endpoint:**
   Open a browser or use cURL:
   ```bash
   curl http://localhost:8080/api/reports/generate
   ```
   You should see output similar to:
   ```json
   {
     "status": "Success",
     "message": "Report generated successfully!",
     "executedOn": "VirtualThread[#46,tomcat-handler-1]/runnable@ForkJoinPool-1-worker-2"
   }
   ```

## Running via Docker
If you prefer running the application in an isolated container:

1. **Build the image:**
   ```bash
   docker build -t virtual-threads-demo .
   ```

2. **Run the container:**
   ```bash
   docker run -p 8080:8080 virtual-threads-demo
   ```
