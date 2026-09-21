package com.webcodein.fullstack.reactive.service;

import com.webcodein.fullstack.reactive.model.Task;
import com.webcodein.fullstack.reactive.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaskServiceUnitTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    void testGetAllTasks() {
        Task task1 = new Task("Test 1", false);
        Task task2 = new Task("Test 2", true);
        when(taskRepository.findAll()).thenReturn(Flux.just(task1, task2));

        StepVerifier.create(taskService.getAllTasks())
                .expectNext(task1)
                .expectNext(task2)
                .verifyComplete();
    }

    @Test
    void testToggleTaskCompletion() {
        Task task = new Task("Test 1", false);
        task.setId(1L);
        when(taskRepository.findById(1L)).thenReturn(Mono.just(task));
        when(taskRepository.save(any(Task.class))).thenAnswer(invocation -> {
            Task t = invocation.getArgument(0);
            return Mono.just(t);
        });

        StepVerifier.create(taskService.toggleTaskCompletion(1L))
                .expectNextMatches(Task::isCompleted)
                .verifyComplete();
    }
}
