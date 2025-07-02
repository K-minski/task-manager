package dev.dtk.task_manager;

import dev.dtk.task_manager.Task.Task;
import dev.dtk.task_manager.Task.TaskStatus;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TaskRepositoryTest {

    @Test
    void create() {
        TaskRepository repository = new TaskRepository();
        Task verificationTask = new Task("This task is to verify presence in repository");
        for (int i = 0; i < 4; i++) {
            if (i == 3){
                repository.create(verificationTask);
            }else{
                repository.create(new Task("Other tasks"));
            }
        }
        assertEquals(verificationTask.getDescription(),repository.findTaskById(verificationTask.getId()).getDescription());
    }

    @Test
    void remove() {
        Task verificationTask = new Task("This task is to verify presence in repository");
        TaskRepository repository = new TaskRepository();
        repository.findAll().addAll(List.of(
                new Task("Lista 1 - Zadanie 1: Utworzenie projektu w wybranej technologii"),
                new Task("Lista 1 - Zadanie 2: Rozbudowa README"),
                new Task("Lista 2 - Zadanie 1: Workflow z gałęziami"),
                verificationTask,
                new Task("Lista 3 - Zadanie główne: Kompleksowe wdrożenie projektu"),
                new Task("Lista 3 - Zadanie dodatkowe 1: Multi-environment deployment")
        ));

        repository.remove(verificationTask.getId());
        assertFalse(repository.findAll().contains(verificationTask));

    }

    @Test
    void statusUpdate() {
        TaskRepository repository = new TaskRepository();
        repository.findAll().addAll(List.of(
                new Task("Lista 1 - Zadanie 1: Utworzenie projektu w wybranej technologii"),
                new Task("Lista 1 - Zadanie 2: Rozbudowa README"),
                new Task("Lista 2 - Zadanie 1: Workflow z gałęziami"),
                new Task("Lista 3 - Zadanie główne: Kompleksowe wdrożenie projektu"),
                new Task("Lista 3 - Zadanie dodatkowe 1: Multi-environment deployment")
        ));
        // Pick randomly one of positions from list to change status
        String randomId = repository.findAll().get(new Random().nextInt(repository.findAll().size())).getId();

        repository.statusUpdate(randomId);
        for (Task task : repository.findAll()) {
            if (task.getStatus() == TaskStatus.COMPLETED) {
                // Check if one of pointed tasks changed status
                assertEquals(randomId, task.getId());

            }else{
                // Check if there was no random changes to list.
                assertEquals(task.getStatus(),TaskStatus.NOT_STARTED);
            }
        }
    }
}