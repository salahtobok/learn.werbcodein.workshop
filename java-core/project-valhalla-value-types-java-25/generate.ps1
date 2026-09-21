$base = "C:\Users\salaheddine.tobok\IdeaProjects\learn.webcodein.com\workshop\java-core\project-valhalla-value-types-java-25"
$src = "$base\src\main\java\com\webcodein\valhalla"
$test = "$base\src\test\java\com\webcodein\valhalla"
New-Item -ItemType Directory -Force -Path "$src\benchmark"
New-Item -ItemType Directory -Force -Path "$src\entity"
New-Item -ItemType Directory -Force -Path "$src\repository"
New-Item -ItemType Directory -Force -Path "$src\controller"
New-Item -ItemType Directory -Force -Path "$test"
New-Item -ItemType Directory -Force -Path "$base\src\main\resources"

@"
package com.webcodein.valhalla;

public value class Point {
    private int x;
    private int y;
    public Point(int x, int y) { this.x = x; this.y = y; }
    public int getX() { return x; }
    public int getY() { return y; }
}
"@ | Out-File "$src\Point.java" -Encoding UTF8

@"
package com.webcodein.valhalla;

public class StandardPoint {
    private int x;
    private int y;
    public StandardPoint(int x, int y) { this.x = x; this.y = y; }
    public int getX() { return x; }
    public int getY() { return y; }
}
"@ | Out-File "$src\StandardPoint.java" -Encoding UTF8

@"
package com.webcodein.valhalla.benchmark;

import com.webcodein.valhalla.Point;
import com.webcodein.valhalla.StandardPoint;
import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class MemoryLayoutBenchmark {

    private Point[] valueArray = new Point[1_000_000];
    private StandardPoint[] objectArray = new StandardPoint[1_000_000];

    @Setup
    public void setup() {
        for (int i = 0; i < 1_000_000; i++) {
            valueArray[i] = new Point(i, i);
            objectArray[i] = new StandardPoint(i, i);
        }
    }

    @Benchmark
    public long benchmarkValueTypes() {
        long sum = 0;
        for (Point p : valueArray) {
            sum += p.getX();
        }
        return sum;
    }

    @Benchmark
    public long benchmarkStandardObjects() {
        long sum = 0;
        for (StandardPoint p : objectArray) {
            sum += p.getX();
        }
        return sum;
    }
}
"@ | Out-File "$src\benchmark\MemoryLayoutBenchmark.java" -Encoding UTF8

@"
package com.webcodein.valhalla.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class BenchmarkRun {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private long throughput;

    public BenchmarkRun() {}
    public BenchmarkRun(String name, long throughput) {
        this.name = name;
        this.throughput = throughput;
    }
    
    public Long getId() { return id; }
    public String getName() { return name; }
    public long getThroughput() { return throughput; }
}
"@ | Out-File "$src\entity\BenchmarkRun.java" -Encoding UTF8

@"
package com.webcodein.valhalla.repository;

import com.webcodein.valhalla.entity.BenchmarkRun;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BenchmarkRunRepository extends JpaRepository<BenchmarkRun, Long> {}
"@ | Out-File "$src\repository\BenchmarkRunRepository.java" -Encoding UTF8

@"
package com.webcodein.valhalla.controller;

import com.webcodein.valhalla.entity.BenchmarkRun;
import com.webcodein.valhalla.repository.BenchmarkRunRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/benchmarks")
public class BenchmarkController {
    
    private final BenchmarkRunRepository repository;
    
    public BenchmarkController(BenchmarkRunRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping
    public List<BenchmarkRun> getAll() {
        return repository.findAll();
    }
    
    @PostMapping
    public BenchmarkRun create(@RequestBody BenchmarkRun run) {
        return repository.save(run);
    }
}
"@ | Out-File "$src\controller\BenchmarkController.java" -Encoding UTF8

@"
package com.webcodein.valhalla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ValhallaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ValhallaApplication.class, args);
    }
}
"@ | Out-File "$src\ValhallaApplication.java" -Encoding UTF8

@"
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
"@ | Out-File "$base\src\main\resources\application.properties" -Encoding UTF8

@"
package com.webcodein.valhalla;

import com.webcodein.valhalla.entity.BenchmarkRun;
import com.webcodein.valhalla.repository.BenchmarkRunRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class ValhallaApplicationTests {

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BenchmarkRunRepository repository;

    @Test
    void contextLoadsAndCanSaveRun() {
        BenchmarkRun run = new BenchmarkRun("ValueTypeTest", 15000L);
        BenchmarkRun saved = restTemplate.postForObject("/api/benchmarks", run, BenchmarkRun.class);
        
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getName()).isEqualTo("ValueTypeTest");
        
        assertThat(repository.count()).isGreaterThan(0);
    }
}
"@ | Out-File "$test\ValhallaApplicationTests.java" -Encoding UTF8

@"
FROM eclipse-temurin:25-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY `${JAR_FILE} app.jar
ENTRYPOINT ["java","--enable-preview","-jar","/app.jar"]
"@ | Out-File "$base\Dockerfile" -Encoding UTF8

@"
services:
  postgres:
    image: postgres:16-alpine
    environment:
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: password
      POSTGRES_DB: postgres
    ports:
      - "5432:5432"
"@ | Out-File "$base\docker-compose.yml" -Encoding UTF8

@"
# Project Valhalla Performance Benchmark (Workshop)

Companion code for the article **Project Valhalla Value Types in Java 25: A Performance Deep Dive**.

## Prerequisites
- Java 25 (with `--enable-preview`)
- Maven 3.9+
- Docker (for Testcontainers during tests)

## Building the Project
Use the Maven wrapper to build the project and run the tests:
```bash
./mvnw clean verify
```

## Running the Application Locally
To run the Spring Boot application locally, you must first start the PostgreSQL database via Docker Compose:
```bash
docker-compose up -d
./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="--enable-preview"
```
"@ | Out-File "$base\README.md" -Encoding UTF8
