package repositories;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Respuesta;


@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Integer>{
	
			// Como no almacenamos las preguntas en la base de datos, vamos a distinguir todas la preguntas que hay en la encuesta-votacion
		@Query("select distinct r.pregunta from Respuesta r where r.voto.votacion = ?1")
		Collection<String> preguntasDeUnaVotacion(int votacionId);
		
			// Respuestas de una pregunta determinada
		@Query("select distinct r.opcion from Respuesta r where r.voto.votacion = ?1 and r.pregunta = ?2")
		Collection<String> opcionesDeUnaVotacion(int votacionId, String pregunta);
		
				// Distintos CP que hay en una votación
		@Query("select distinct r.voto.cp from Respuesta r where r.voto.votacion = ?1")
		Collection<Integer> cpsDeUnaVotacion(int votacionId);
	
	
}
