/* UserAccountRepository.java
 *
 * Copyright (C) 2014 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package repositories;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Votacion;


@Repository
public interface VotacionRepository extends JpaRepository<Votacion, Integer> {
	
	@Query("select v from Votacion v where v.nombre = ?1")
	Collection<Votacion> findByNombre(String nombre);
	
	
	/* ESTOS DOS PRIMEROS METODOS SON MUY ESPECIFICOS, PARA LA OBTENCIÓN TOTAL SE UTILIZARÁN LOS MÉTODOS DE RECUENTO 4 Y 5 
	 * QUE NOS OFRECEN TODA ESTA INFORMACIÓN
	 */
		// 1. Cuantos respondieron a la pregunta X?
	@Query("select count(r) from Respuesta r where r.voto.votacion = ?1 and r.pregunta = ?2")
	int numeroRespuestasPorPreguntaYVotacion(int votacionId, String pregunta);
	
		// 2. Cuantos respondieron con Y a la pregunta X
	@Query("select count(r) from Respuesta r where r.voto.votacion = ?1 and r.pregunta = ?2 and r.opcion = ?3")
	int numeroRespuestasPorPreguntaRespuestayVotacion(int votacionId, String pregunta, String opcion);
	
		// 3. Calculemos el ratio para una determinada votacion de los usuarios que eligieron Y en la pregunta X - "El 8% votó IU"
	@Query("select 1.0*count(r)/(select count(r1) from Respuesta r1 where r1.voto.votacion = ?1 and r1.pregunta = ?2) from Respuesta r " +
			"where r.voto.votacion = ?1 and r.pregunta = ?2 and r.opcion = ?3")
	double ratioRespuestasParaUnaOpcion(int votacionId, String pregunta, String opcion);
	
			// 3.b Calculemos el ratio para una determinada votacion y CP de los usuarios que eligieron Y en la pregunta X - "El 30% de los ANDALUCES votó PSOE"
	@Query("select 1.0*count(r)/(select count(r1) from Respuesta r1 where r1.voto.votacion = ?1 and r1.pregunta = ?2 and r1.voto.cp = ?4) from Respuesta r " +
				"where r.voto.votacion = ?1 and r.pregunta = ?2 and r.opcion = ?3 and r.voto.cp = ?4")
	double ratioRespuestasParaUnaOpcionConCP(int votacionId, String pregunta, String opcion, Integer cp);
	
		// 4. Recuento de una deteminada pregunta (Siempre en el marco de una votacion)
	@Query("select count(r.opcion), r.opcion from Respuesta r where r.voto.votacion = ?1 and r.pregunta = ?2 group by r.opcion")
	Collection<Object[]> recuentaParaUnaDeterminaPregunta(int votacionId, String pregunta);
	
		// 5. Recuento de una deteminada pregunta POR CP(Siempre en el marco de una votacion)
	@Query("select count(r.opcion), r.opcion from Respuesta r where r.voto.votacion = ?1 and r.pregunta = ?2 and r.voto.cp = ?3 group by r.opcion")
	Collection<Object[]> recuentaParaUnaDeterminaPreguntaYCP(int votacionId, String pregunta, int cp);
		
	
}
