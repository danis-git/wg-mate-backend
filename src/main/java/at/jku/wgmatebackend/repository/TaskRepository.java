package at.jku.wgmatebackend.repository;

import at.jku.wgmatebackend.model.entity.Flat;
import at.jku.wgmatebackend.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository()
public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query("select f from Flat f where f.flatId=:flatid")
    Flat getExpanses(@Param("flatid") int flatid);
}
