package com.webcodein.taskmanager.domain.service;

import com.webcodein.taskmanager.domain.model.Project;
import com.webcodein.taskmanager.domain.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class TaskAssignmentService {
    private final ProjectRepository projectRepository;

    public TaskAssignmentService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void assignTask(UUID projectId, String taskTitle) {
        Project project = projectRepository.findById(projectId)
            .orElseThrow(() -> new IllegalArgumentException("Project not found"));
        project.addTask(taskTitle);
        projectRepository.save(project);
    }
}