package at.jku.wgmatebackend.controller;

import at.jku.wgmatebackend.model.DTO.TaskDTO;
import at.jku.wgmatebackend.model.entity.Flat;
import at.jku.wgmatebackend.model.entity.Task;
import at.jku.wgmatebackend.model.entity.TaskTemplate;
import at.jku.wgmatebackend.repository.FlatRepository;
import at.jku.wgmatebackend.repository.TaskRepository;
import at.jku.wgmatebackend.repository.TaskTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/task")
public class TaskTemplateController {

    @Autowired
    TaskTemplateRepository taskTemplateRepository;
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    FlatRepository flatRepository;

    @RequestMapping("/new/task-template")
    @PostMapping()
    public void createTaskTemplate(@RequestBody TaskTemplate taskTemplate) {
        taskTemplateRepository.save(taskTemplate);
        // todo: new Tasks
    }

    @RequestMapping("/new")
    @PostMapping()
    public void createTask(@RequestBody TaskDTO taskDTO) {
        System.out.println("Grüßli----------------------------------------");
        Task task = taskDTO.toTask();

        System.out.println(task.toString());

        taskRepository.save(task);

        // todo: new Tasks
    }

    @RequestMapping("/{flatId}")
    @GetMapping
    public List<Task> getTasks(@PathVariable(value = "flatId") int flatId) {

        Flat flat = flatRepository.getById(flatId);

        return flat.getTasks();
    }
}
