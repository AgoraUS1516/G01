package domain;


import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

// INPUT
@Entity
@Access(AccessType.PROPERTY)
public class Respuesta extends DomainEntity {
	
	public String pregunta;
	public String opcion;
	
	
	
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	
	
	public String getOpcion() {
		return opcion;
	}
	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}
	
	// Relationships 
	
	public Voto voto;


	@ManyToOne(optional = false)
	public Voto getVoto() {
		return voto;
	}
	public void setVoto(Voto voto) {
		this.voto = voto;
	}
	
	
	
	

}
