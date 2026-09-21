package com.webcodein.fullstack.reactive.service;

import com.webcodein.fullstack.reactive.model.Task;
import com.webcodein.fullstack.reactive.repository.TaskRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Flux<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Mono<Task> createTask(Task task) {
        return taskRepository.save(task);
    }

    public Mono<Task> toggleTaskCompletion(Long id) {
        return taskRepository.findById(id)
            .flatMap(task -> {
                task.setCompleted(!task.isCompleted());
                return taskRepository.save(task);
            });
    }

    public Mono<Void> deleteTask(Long id) {
        return taskRepository.deleteById(id);
    }
}
