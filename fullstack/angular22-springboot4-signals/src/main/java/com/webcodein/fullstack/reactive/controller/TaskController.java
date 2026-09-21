package com.webcodein.fullstack.reactive.controller;

import com.webcodein.fullstack.reactive.model.Task;
import com.webcodein.fullstack.reactive.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public Flux<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Task> createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PatchMapping("/{id}/toggle")
    public Mono<Task> toggleTask(@PathVariable Long id) {
        return taskService.toggleTaskCompletion(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteTask(@PathVariable Long id) {
        return taskService.deleteTask(id);
    }
}
