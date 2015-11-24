package domain;



import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;



@Entity
@Access(AccessType.PROPERTY)
public class Resultado extends DomainEntity{
	private String pregunta;
	
	
	public Resultado(){
		super();
	}
	
	@NotBlank
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	
	
	// Relationships ----------------------------------------------------------
	private Votacion votacion;
	private Collection<Opcion> opciones;	
	
	@Valid
	@ManyToOne(optional=true)
	public Votacion getVotacion() {
		return votacion;
	}

	public void setVotacion(Votacion votacion) {
		this.votacion = votacion;
	}
	
	@NotNull
	@Valid
	@OneToMany(mappedBy="result")
	public Collection<Opcion> getOpciones() {
		return opciones;
	}

	public void setOpciones(Collection<Opcion> opciones) {
		this.opciones = opciones;
	}
	
	
	
}
