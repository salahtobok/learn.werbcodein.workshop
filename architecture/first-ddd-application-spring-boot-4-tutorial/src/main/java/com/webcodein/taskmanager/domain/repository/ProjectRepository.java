package com.webcodein.taskmanager.domain.repository;

import com.webcodein.taskmanager.domain.model.Project;
import java.util.Optional;
import java.util.UUID;

public interface ProjectRepository {
    void save(Project project);
    Optional<Project> findById(UUID id);
}