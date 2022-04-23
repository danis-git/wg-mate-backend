package at.jku.wgmatebackend.repository;

import at.jku.wgmatebackend.model.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
}
