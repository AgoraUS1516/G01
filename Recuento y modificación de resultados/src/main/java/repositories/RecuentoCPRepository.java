package repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.RecuentoCP;


@Repository
public interface RecuentoCPRepository extends JpaRepository<RecuentoCP, Integer>{

	
	
}
