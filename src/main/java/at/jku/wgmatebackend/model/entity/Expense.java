package at.jku.wgmatebackend.model.entity;

import javax.persistence.*;
import java.time.YearMonth;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer expenseId;

    private String name;
    private float costs; // [€]
    private YearMonth startDate;

    @ManyToOne
    @JoinColumn(name = "Flat_ID")
    private Flat flat;

    @ManyToOne
    @JoinColumn(name = "Main_Payer")
    private User mainPayer;

    @ManyToMany
    @JoinTable(name="Share_Expense",
            joinColumns=@JoinColumn(name="EXPENSE_ID"),
            inverseJoinColumns=@JoinColumn(name="USER_ID"))
    private Set<User> sharePayer = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "EXPENSE_TEMPLATE_ID")
    private ExpenseTemplate expenseTemplate;



    public Integer getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Integer id) {
        this.expenseId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCosts() {
        return costs;
    }

    public void setCosts(float costs) {
        this.costs = costs;
    }

    public YearMonth getStartDate() {
        return startDate;
    }

    public void setStartDate(YearMonth startDate) {
        this.startDate = startDate;
    }
}
