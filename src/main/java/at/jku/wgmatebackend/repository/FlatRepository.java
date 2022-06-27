package at.jku.wgmatebackend.repository;

import at.jku.wgmatebackend.model.entity.Flat;
import at.jku.wgmatebackend.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public interface FlatRepository extends JpaRepository<Flat, Integer> {

    @Query("select f from Flat f, User u where u.userId=:userid and f.owner.userId=:userid")
    Flat getNames(@Param("userid") int userid);
}
