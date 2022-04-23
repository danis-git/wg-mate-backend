package at.jku.wgmatebackend.repository;


import at.jku.wgmatebackend.model.entity.ExpenseTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface ExpenseTemplateRepository extends JpaRepository<ExpenseTemplate, Integer> {
}
