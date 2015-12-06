package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Opcion;

@Repository
public interface RecuentoOpcionRepository extends JpaRepository<Opcion, Integer> {

}
