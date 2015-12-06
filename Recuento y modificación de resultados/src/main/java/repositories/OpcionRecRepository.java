package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import domain.OpcionRec;

@Repository
public interface OpcionRecRepository extends JpaRepository<OpcionRec, Integer> {

}
