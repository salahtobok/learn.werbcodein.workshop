package com.webcodein.valhalla.repository;

import com.webcodein.valhalla.entity.BenchmarkRun;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BenchmarkRunRepository extends JpaRepository<BenchmarkRun, Long> {}
