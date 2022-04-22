package at.jku.wgmatebackend.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.YearMonth;

@Entity
public class ExpenseTemplate {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;
    private float costs; // [€]
    private RepetitionType repetitionType;
    private YearMonth startDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
