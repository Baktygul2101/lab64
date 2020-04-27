package kg.attractor.votemachine.controller;


import kg.attractor.votemachine.model.Task;
import kg.attractor.votemachine.model.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@Controller
public class TaskController {

    private final TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String root(Model model) {
        model.addAttribute("tasks", repository.findAll());
        return "tasks";
    }



    @GetMapping("/task")
    public String rootGet(Model model) {
        return "addtask";
    }

    @PostMapping("/task")
    public String rootSave(@RequestParam("title") String title) throws IOException {
        Task t = new Task(title);
        repository.save(t);
        return "success";
    }

    @GetMapping("/tasks")
    @ResponseBody
    public Iterable<Task> getTaskList() {
        return repository.findAll();
    }

}
