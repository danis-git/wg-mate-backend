package at.jku.wgmatebackend.repository;

import at.jku.wgmatebackend.model.entity.Flat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface FlatRepository extends JpaRepository<Flat, Integer> {
}
