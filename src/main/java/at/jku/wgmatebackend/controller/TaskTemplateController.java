package at.jku.wgmatebackend.controller;

import at.jku.wgmatebackend.model.DTO.TaskDTO;
import at.jku.wgmatebackend.model.entity.Task;
import at.jku.wgmatebackend.model.entity.TaskTemplate;
import at.jku.wgmatebackend.repository.TaskRepository;
import at.jku.wgmatebackend.repository.TaskTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/task")
public class TaskTemplateController {

    @Autowired
    TaskTemplateRepository taskTemplateRepository;
    @Autowired
    TaskRepository taskRepository;

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
}
