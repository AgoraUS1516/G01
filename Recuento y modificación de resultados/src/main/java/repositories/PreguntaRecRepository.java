package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Opcion;

@Repository
public interface PreguntaRecRepository extends JpaRepository<Opcion, Integer> {

}
