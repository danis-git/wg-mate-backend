package at.jku.wgmatebackend.controller;

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

    @RequestMapping("/new/{flatId}")
    @PostMapping()
    public void createTask(@PathVariable(value = "flatId") int flatId, @RequestBody Task task) {
        Flat flat = flatRepository.getById(flatId);
        task.setFlat(flat);
        taskRepository.save(task);
    }

    @RequestMapping("/{flatId}")
    @GetMapping
    public List<Task> getTasks(@PathVariable(value = "flatId") int flatId) {

        Flat flat = flatRepository.getById(flatId);

        return flat.getTasks();
    }
}
