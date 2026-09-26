package com.webcodein.workshop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import java.util.UUID;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private TaskStatus status;
    
    protected Task() {} 

    public Task(String title) {
        this.title = title;
        this.status = TaskStatus.TODO;
    }
    
    public void markAsDone() {
        this.status = TaskStatus.DONE;
    }
}
