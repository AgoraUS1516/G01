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

@Entity
@Access(AccessType.PROPERTY)
public class Voto extends DomainEntity {

	private int cP;

	public int getcP() {
		return cP;
	}

	public void setcP(int cP) {
		this.cP = cP;
	}

	// Relationships ----------------------------------------

	private Collection<Respuesta> respuestas;
	private Votacion votacion;

	@NotNull
	@Valid
	@OneToMany(mappedBy = "voto", cascade = CascadeType.ALL)
	public Collection<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(Collection<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}
	
	@Valid
	@ManyToOne(optional = false)
	public Votacion getVotacion() {
		return votacion;
	}

	public void setVotacion(Votacion votacion) {
		this.votacion = votacion;
	}

}