package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

// OUTPUT
@Entity
@Access(AccessType.PROPERTY)
public abstract class Recuento extends DomainEntity{
	
	private String pregunta;
	private String opcion;
	private Integer opcionCount;
	
	
	@NotBlank
	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	
	@NotBlank
	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}
	
	@Min(0)
	@NotNull
	public Integer getOpcionCount() {
		return opcionCount;
	}

	public void setOpcionCount(Integer opcionCount) {
		this.opcionCount = opcionCount;
	}
	
	
	// Relationships
	
	private VotacionRec votacionRec;

	@ManyToOne(optional = false)
	public VotacionRec getVotacionRec() {
		return votacionRec;
	}

	public void setVotacionRec(VotacionRec votacionRec) {
		this.votacionRec = votacionRec;
	}
	
	
	
	
}
