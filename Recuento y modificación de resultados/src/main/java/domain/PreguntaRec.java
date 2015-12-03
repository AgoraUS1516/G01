package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class PreguntaRec extends DomainEntity {

	private String pregunta;

	@NotBlank
	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	// Relationships ----------------------------------------

	private Collection<OpcionRec> opcionRecs;
	private VotacionRec votacionRec;

	@NotNull
	@Valid
	@OneToMany(mappedBy = "preguntaRec", cascade = CascadeType.ALL)
	public Collection<OpcionRec> getOpcionRecs() {
		return opcionRecs;
	}

	public void setOpcionRecs(Collection<OpcionRec> opcionRecs) {
		this.opcionRecs = opcionRecs;
	}

	@Valid
	@ManyToOne(optional = false)
	public VotacionRec getVotacionRec() {
		return votacionRec;
	}

	public void setVotacionRec(VotacionRec votacionRec) {
		this.votacionRec = votacionRec;
	}

}
