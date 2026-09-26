package com.webcodein.taskmanager.infrastructure.persistence;

import com.webcodein.taskmanager.domain.model.Project;
import com.webcodein.taskmanager.domain.repository.ProjectRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class JpaProjectRepository implements ProjectRepository {
    private final SpringDataProjectRepository repository;

    public JpaProjectRepository(SpringDataProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Project project) {
        repository.save(project);
    }

    @Override
    public Optional<Project> findById(UUID id) {
        return repository.findById(id);
    }
}