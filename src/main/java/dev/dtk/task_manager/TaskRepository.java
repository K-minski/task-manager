package dev.dtk.task_manager;

import dev.dtk.task_manager.Task.Task;
import dev.dtk.task_manager.Task.TaskStatus;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {

    private final List<Task> tasks = new ArrayList<>();

    public List<Task> findAll() {
        return tasks;
    }

    public Task findTaskById(String id){
        for (Task task : tasks){
            if( id.equals(task.getId())){
                return task;
            }
        }
        return null;
    }

    public void create(Task task) {
        tasks.add(task);
    }

    public boolean remove(String id) {
        return tasks.removeIf(task -> task.getId().equals(id));
    }

    public void statusUpdate(String id) {
        findTaskById(id).setStatus(TaskStatus.COMPLETED);
    }

    public void descriptionUpdate(String id, String description){
        findTaskById(id).setDescription(description);
    }

    // Initial list of sample temporary tasks
    @PostConstruct
    private void init() {
        tasks.addAll(List.of(
                new Task("Lista 1 - Zadanie 1: Utworzenie projektu w wybranej technologii"),
                new Task("Lista 1 - Zadanie 2: Rozbudowa README"),
                new Task("Lista 1 - Zadanie 3: Śledzenie i ignorowanie plików"),
                new Task("Lista 1 - Zadanie 4: Historia zmian"),
                new Task("Lista 1 - Zadanie 5: Dodatkowe pliki dokumentacji"),
                new Task("Lista 2 - Zadanie 1: Workflow z gałęziami"),
                new Task("Lista 2 - Zadanie 2: Zarządzanie konfliktami"),
                new Task("Lista 2 - Zadanie 3: Semantic versioning"),
                new Task("Lista 2 - Zadanie 4: Test-driven development"),
                new Task("Lista 2 - Zadanie 5: Kompleksowy workflow"),
                new Task("Lista 3 - Zadanie główne: Kompleksowe wdrożenie projektu"),
                new Task("Lista 3 - Zadanie dodatkowe 1: Multi-environment deployment"),
                new Task("Lista 3 - Zadanie dodatkowe 2: Advanced monitoring"),
                new Task("Lista 3 - Zadanie dodatkowe 3: Multi-platform deployment")
        ));
    }

}