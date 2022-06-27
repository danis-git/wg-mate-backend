package at.jku.wgmatebackend.model.DTO;

import at.jku.wgmatebackend.model.entity.Flat;
import at.jku.wgmatebackend.model.entity.Task;
import at.jku.wgmatebackend.model.entity.User;
import at.jku.wgmatebackend.repository.TaskRepository;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TaskDTO {

    private TaskRepository taskRepository;

    private String name;
    private String startDate; // todo: could make problems
    private Flat flat;
    private Set<User> assignedUser = new HashSet<>();


    public Task toTask() {
        Date date;

        System.out.println(startDate);


        TemporalAccessor ta = DateTimeFormatter.ISO_INSTANT.parse(startDate);
        Instant i = Instant.from(ta);
        date = Date.from(i);

        System.out.println(date);


        return new Task(
                name,
                date,
                flat,
                assignedUser
        );
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    public Set<User> getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(Set<User> assignedUser) {
        this.assignedUser = assignedUser;
    }
}
