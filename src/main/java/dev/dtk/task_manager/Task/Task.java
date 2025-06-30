package dev.dtk.task_manager.Task;

import java.util.UUID;

public class Task {
    private final String id;
    private final String description;
    private TaskStatus status;

    public Task(String description) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.status = TaskStatus.NOT_STARTED;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}