package at.jku.wgmatebackend.model.entity;

import at.jku.wgmatebackend.model.enums.RepetitionType;

import javax.persistence.*;
import java.time.YearMonth;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class ExpenseTemplate {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer expenseTemplateId;

    private String name;
    private float costs; // [€]
    private RepetitionType repetitionType;
    private YearMonth startDate;

    @ManyToOne
    @JoinColumn(name = "Flat_ID")
    private Flat flat;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User mainPayer;

    @ManyToMany
    @JoinTable(name="Share_Expense_Template",
            joinColumns=@JoinColumn(name="EXPENSE_TEMPLATE_ID"),
            inverseJoinColumns=@JoinColumn(name="USER_ID"))
    private Set<User> sharePayer = new HashSet<>();

    @OneToMany(mappedBy = "expenseTemplate")
    private List<Expense> expenses;

    public Integer getExpenseTemplateId() {
        return expenseTemplateId;
    }

    public void setExpenseTemplateId(Integer id) {
        this.expenseTemplateId = id;
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

    public RepetitionType getRepetitionType() {
        return repetitionType;
    }

    public void setRepetitionType(RepetitionType repetitionType) {
        this.repetitionType = repetitionType;
    }

    public YearMonth getStartDate() {
        return startDate;
    }

    public void setStartDate(YearMonth startDate) {
        this.startDate = startDate;
    }
}
