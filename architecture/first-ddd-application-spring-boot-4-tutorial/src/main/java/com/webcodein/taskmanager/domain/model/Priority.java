package com.webcodein.taskmanager.domain.model;

public record Priority(int level, String name) {
    public Priority {
        if (level < 1 || level > 5) {
            throw new IllegalArgumentException("Priority level must be between 1 and 5");
        }
    }
}