package com.webcodein.virtualthreads.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private static final Logger log = LoggerFactory.getLogger(ReportController.class);

    @GetMapping("/generate")
    public Map<String, String> generateReport() throws InterruptedException {
        String threadName = Thread.currentThread().toString();
        log.info("Starting report generation on: {}", threadName);
        
        // Simulating a slow, blocking database query or external API call (100ms for test brevity)
        Thread.sleep(Duration.ofMillis(100));
        
        log.info("Finished report generation on: {}", threadName);
        return Map.of(
            "status", "Success",
            "message", "Report generated successfully!",
            "executedOn", threadName
        );
    }
}
