package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import domain.Resultado;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, Integer>{

}
