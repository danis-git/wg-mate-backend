package at.jku.wgmatebackend.controller;

import at.jku.wgmatebackend.model.entity.Flat;
import at.jku.wgmatebackend.model.entity.Task;
import at.jku.wgmatebackend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskRepository taskRepository;

    @GetMapping()
    public HashMap<String, Task> getAllFlats() {
        List<Task> flats = taskRepository.findAll();
        HashMap<String,Task> map = new HashMap<>();
        for (Task task:flats) {
            //map.put(String.valueOf(task.getFlatId()),flat);
        }
        return map;
    }
}
