package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.VotoAux;
@Repository
public interface VotoAuxRepository extends JpaRepository<VotoAux, Integer>{

}
