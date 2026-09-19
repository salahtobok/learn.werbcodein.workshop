package com.webcodein.ai;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    public record WeatherRequest(String city) {}
    public record WeatherResponse(String city, String condition, int temperatureC) {}

    @Tool(description = "Get the current weather for a specific city")
    public WeatherResponse getWeather(WeatherRequest request) {
        // In a real application, this would call an external weather API.
        // For the demo, we return mock data.
        return new WeatherResponse(request.city(), "Sunny", 24);
    }
}
