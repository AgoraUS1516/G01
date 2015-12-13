package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.VotacionRec;


@Repository
public interface VotacionRecRepository extends JpaRepository<VotacionRec, Integer> {
	
	

}
