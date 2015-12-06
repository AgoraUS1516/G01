package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import domain.RecuentoOpcion;

@Repository
public interface RecuentoOpcionRepository extends JpaRepository<RecuentoOpcion, Integer> {

}
