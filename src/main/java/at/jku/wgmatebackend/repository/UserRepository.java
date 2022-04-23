package at.jku.wgmatebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import at.jku.wgmatebackend.model.entity.User;
import org.springframework.stereotype.Repository;

@Repository()
public interface UserRepository extends JpaRepository<User, Integer> {
}