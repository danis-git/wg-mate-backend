package at.jku.wgmatebackend.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Flat {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer flatId;

    private String name;
    private Integer area; // [m²]

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "userId")
    private User owner;

    @ManyToMany
    @JoinTable(name="CoOwnerFlats",
            joinColumns=@JoinColumn(name="FLAT_ID"),
            inverseJoinColumns=@JoinColumn(name="CO_USER_ID"))
    private Set<User> coOwner = new HashSet<>();

    @OneToMany(mappedBy = "flat")
    private List<Expense> expenses;

    @OneToMany(mappedBy = "flat")
    private List<ExpenseTemplate> expenseTemplates;

    @OneToMany(mappedBy = "flat")
    private List<Task> tasks;

    @OneToMany(mappedBy = "flat")
    private List<TaskTemplate> taskTemplates;


    public void setFlatId(Integer id) {
        this.flatId = id;
    }

    public Integer getFlatId() {
        return flatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }
}
