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
