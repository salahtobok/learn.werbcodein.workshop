package com.webcodein.fullstack.reactive.repository;

import com.webcodein.fullstack.reactive.model.Task;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TaskRepository extends ReactiveCrudRepository<Task, Long> {
}
