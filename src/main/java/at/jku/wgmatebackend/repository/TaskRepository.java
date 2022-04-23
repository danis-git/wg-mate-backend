package at.jku.wgmatebackend.repository;

import at.jku.wgmatebackend.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface TaskRepository extends JpaRepository<Task, Integer> {
}
