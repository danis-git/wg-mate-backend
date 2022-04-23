package at.jku.wgmatebackend.model.entity;

import at.jku.wgmatebackend.model.enums.RepetitionType;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class TaskTemplate {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer taskTemplateId;

    private String name;
    private RepetitionType repetitionType;
    private Date startDate; //TODO Date? or other

    @ManyToOne
    @JoinColumn(name = "Flat_ID")
    private Flat flat;

    @OneToMany(mappedBy = "taskTemplate")
    private List<Task> tasks;

    @ManyToMany
    @JoinTable(name="Assigned_User_TaskTemplates",
            joinColumns=@JoinColumn(name="TASK_TEMPLATE_ID"),
            inverseJoinColumns=@JoinColumn(name="USER_ID"))
    private Set<User> assignedUser = new HashSet<>();


    public Integer getTaskTemplateId() {
        return taskTemplateId;
    }

    public void setTaskTemplateId(Integer id) {
        this.taskTemplateId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RepetitionType getRepetitionType() {
        return repetitionType;
    }

    public void setRepetitionType(RepetitionType repetitionType) {
        this.repetitionType = repetitionType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
