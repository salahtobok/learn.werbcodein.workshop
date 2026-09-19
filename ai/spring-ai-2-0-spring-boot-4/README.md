# Spring AI 2.0 with Spring Boot 4

This is the companion code for the article: [Spring AI 2.0: The Complete Guide to AI Integration in Spring Boot 4](https://learn.webcodein.com/post/spring-ai-2-0-spring-boot-4-complete-guide).

It demonstrates:
- Bootstrapping a Spring AI 2.0.x project
- Fluent `ChatClient` API
- Structured outputs
- Method-based Tool Calling / Function Calling (`@Tool`)

## Prerequisites
- Java 25
- Maven
- An OpenAI API Key

## Running the Application
Set your OpenAI API key in your environment:
```bash
export OPENAI_API_KEY=your-key-here
```

Then run the application:
```bash
mvn spring-boot:run
```

## Testing the Endpoints

### Basic Chat
```bash
curl http://localhost:8080/api/chat?message=Tell%20me%20a%20java%20joke
```

### Function Calling (Tool)
This endpoint automatically invokes the `WeatherService` using tool calling to retrieve mock weather data.
```bash
curl http://localhost:8080/api/weather?city=Paris
```
