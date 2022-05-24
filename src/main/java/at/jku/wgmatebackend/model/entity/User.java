package at.jku.wgmatebackend.model.entity;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer userId;
    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "owner")
    private List<Flat> ownerFlats;

    @ManyToMany(mappedBy = "coOwner")
    private Set<Flat> coFlats = new HashSet<>();

    @ManyToMany(mappedBy = "assignedUser")
    private Set<Task> assignedTasks = new HashSet<>();

    @ManyToMany(mappedBy = "assignedUser")
    private Set<TaskTemplate> assignedTaskTemplates = new HashSet<>();

    @OneToMany(mappedBy = "mainPayer")
    private List<Expense> mainExpenses;

    @ManyToMany(mappedBy = "sharePayer") // TODO
    private Set<Expense> shareExpenses = new HashSet<>();

    @OneToMany(mappedBy = "mainPayer") // TODO
    private List<ExpenseTemplate> mainExpenseTemplates;

    @ManyToMany(mappedBy = "sharePayer") // TODO
    private Set<ExpenseTemplate> shareExpenseTemplates = new HashSet<>();

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer id) {
        this.userId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}