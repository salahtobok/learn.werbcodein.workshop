package com.webcodein.taskmanager.domain.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Project {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "project_id")
    private List<Task> tasks = new ArrayList<>();

    protected Project() {}

    public Project(String name) {
        this.name = name;
    }

    public void addTask(String title) {
        this.tasks.add(new Task(title));
    }
}