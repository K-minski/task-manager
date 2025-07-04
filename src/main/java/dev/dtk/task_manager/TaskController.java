package dev.dtk.task_manager;

import dev.dtk.task_manager.Task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    private static final Logger log = LoggerFactory.getLogger(TaskController.class);
    private final TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", repository.findAll());
        return "index";
    }

    @PostMapping("/add-task")
    public String addTask(@RequestParam String description, Model model) {
        Task newTask = new Task(description);
        repository.create(newTask);
        model.addAttribute("task", newTask);
        log.info("Task with id: {} was CREATED.", newTask.getId());
        return "task-row";
    }

    @DeleteMapping("/delete-task/{id}")
    @ResponseBody
    public void deleteTask(@PathVariable String id) {
        boolean removed = repository.remove(id);
        log.info("Task with id: {} was DELETED.", id);
    }
    @PatchMapping("/update-task/{id}/status")
    @ResponseBody
    public String updateTaskStatus(@PathVariable String id) {
        repository.statusUpdate(id);
        log.info("Task with id: {} was UPDATED.", id);
        return repository.findTaskById(id).getStatus().toString();
    }

    @GetMapping("/update-task/{id}/edit")
    public String edit(Model model, @PathVariable String id) {
        model.addAttribute("task", repository.findTaskById(id));
        return "task-row-edit";
    }

    @GetMapping("/update-task/{id}/edit-cancel")
    public String cancerEdit(Model model, @PathVariable String id) {
        model.addAttribute("task", repository.findTaskById(id));
        return "task-row";
    }

    @PostMapping("/update-task/{id}/description")
    public String updateTaskDescription(@PathVariable String id, @RequestParam String description, Model model) {
        repository.descriptionUpdate(id, description);
        Task updatedTask = repository.findTaskById(id);
        log.info("Task with id: {} was EDITED.", id);
        model.addAttribute("task", updatedTask);
        return "task-row";
    }
}