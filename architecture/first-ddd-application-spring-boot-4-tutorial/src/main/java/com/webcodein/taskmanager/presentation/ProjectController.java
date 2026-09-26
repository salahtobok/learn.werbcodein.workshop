package com.webcodein.taskmanager.presentation;

import com.webcodein.taskmanager.application.ProjectApplicationService;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectApplicationService appService;

    public ProjectController(ProjectApplicationService appService) {
        this.appService = appService;
    }

    @PostMapping("/{id}/tasks")
    public void addTask(@PathVariable UUID id, @RequestBody TaskRequest request) {
        appService.addTaskToProject(id, request.title());
    }
}

record TaskRequest(String title) {}