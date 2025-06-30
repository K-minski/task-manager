package dev.dtk.task_manager.Task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void getId() {
        Task task = new Task("Some sample description");
        assertNotNull(task.getId());
    }

    @Test
    void getDescription() {
        String testDescription = "Some sample description";
        Task task = new Task(testDescription);
        assertEquals(testDescription, task.getDescription());
    }

    @Test
    void getStatus() {
        Task task = new Task("Some sample description");
        assertEquals(TaskStatus.NOT_STARTED,task.getStatus());
    }

    @Test
    void setStatus() {
        Task task = new Task("Some sample description");
        task.setStatus(TaskStatus.COMPLETED);
        assertEquals(TaskStatus.COMPLETED,task.getStatus());
    }
}