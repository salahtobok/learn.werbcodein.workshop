package com.webcodein.taskmanager.application;

import com.webcodein.taskmanager.domain.service.TaskAssignmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
public class ProjectApplicationService {
    private final TaskAssignmentService taskAssignmentService;

    public ProjectApplicationService(TaskAssignmentService taskAssignmentService) {
        this.taskAssignmentService = taskAssignmentService;
    }

    @Transactional
    public void addTaskToProject(UUID projectId, String title) {
        taskAssignmentService.assignTask(projectId, title);
    }
}