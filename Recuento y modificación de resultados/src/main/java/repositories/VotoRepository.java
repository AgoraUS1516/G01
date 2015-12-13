package repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Voto;


@Repository
public interface VotoRepository extends JpaRepository<Voto, Integer>{
	@Query("select count(vot) from Votacion vot where vot.votacion = ?2")
	int numeroVotosPorVotacion(int votacionId);
	
	@Query("select count(vot) from Votacion vot where vot.cp = ?1 and vot.votacion = ?2")
	int numeroVotosPorVotacionYCp(int cp, int votacionId);
	
	
	
}
