package at.jku.wgmatebackend.model.entity;

import javax.persistence.*;
import java.time.YearMonth;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer taskId;

    private String name;
    private YearMonth startDate;

    @ManyToOne
    @JoinColumn(name = "FLAT_ID")
    private Flat flat;

    @ManyToOne
    @JoinColumn(name = "TASK_TEMPLATE_ID")
    private TaskTemplate taskTemplate;


    @ManyToMany
    @JoinTable(name="assigned_User_Task",
            joinColumns=@JoinColumn(name="TASK_ID"),
            inverseJoinColumns=@JoinColumn(name="USER_ID"))
    private Set<User> assignedUser = new HashSet<>();

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

    public YearMonth getStartDate() {
        return startDate;
    }

    public void setStartDate(YearMonth startDate) {
        this.startDate = startDate;
    }
}
