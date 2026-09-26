package com.webcodein.taskmanager.domain.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {
    @Test
    void shouldAddTaskToProject() {
        Project project = new Project("Website Redesign");
        project.addTask("Design Homepage");
        assertNotNull(project);
    }
}