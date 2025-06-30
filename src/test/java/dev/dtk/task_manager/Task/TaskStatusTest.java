package dev.dtk.task_manager.Task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskStatusTest {

    @Test
    void testToStringForEachStatus() {
        assertEquals("Not Started", TaskStatus.NOT_STARTED.toString());
        assertEquals("In Progress", TaskStatus.IN_PROGRESS.toString());
        assertEquals("Completed", TaskStatus.COMPLETED.toString());
        assertEquals("On Hold", TaskStatus.ON_HOLD.toString());
        assertEquals("Cancelled", TaskStatus.CANCELLED.toString());
    }
}