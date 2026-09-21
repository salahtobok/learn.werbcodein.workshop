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
