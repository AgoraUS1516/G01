package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.VotacionRec;


@Repository
public interface VotacionRecRepository extends JpaRepository<VotacionRec, Integer> {
//	@Query("select v from VotacionRec v where v.nombre = ?1")
//	VotacionRec findByName(String nombre);

}
