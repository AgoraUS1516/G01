package repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.RecuentoGeneral;


@Repository
public interface RecuentoGeneralRepository extends JpaRepository<RecuentoGeneral, Integer>{
	
	
}
