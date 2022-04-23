package at.jku.wgmatebackend.repository;

import at.jku.wgmatebackend.model.entity.TaskTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface TaskTemplateRepository extends JpaRepository<TaskTemplate, Integer> {
}
