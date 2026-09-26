package com.webcodein.taskmanager.infrastructure.persistence;

import com.webcodein.taskmanager.domain.model.Project;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface SpringDataProjectRepository extends CrudRepository<Project, UUID> {}