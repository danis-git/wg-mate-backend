package at.jku.wgmatebackend.model.entity;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer taskId;

    private String name;

    private Date startDate; // todo: could make problems

    @ManyToOne
    @JoinColumn(name = "FLAT_ID")
    private Flat flat;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "TASK_TEMPLATE_ID")
    private TaskTemplate taskTemplate;

    @ManyToMany
    @JoinTable(name = "assigned_User_Task",
            joinColumns = @JoinColumn(name = "TASK_ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID"))
    private Set<User> assignedUser = new HashSet<>();

    public Task(String name, Date startDate, Flat flat, Set<User> assignedUser) {
        this.name = name;
        this.startDate = startDate;
        this.flat = flat;
        this.assignedUser = assignedUser;
    }

    public Task() {

    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer id) {
        this.taskId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        TemporalAccessor ta = DateTimeFormatter.ISO_INSTANT.parse(startDate);
        Instant i = Instant.from(ta);

        this.startDate = Date.from(i);
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }
}
