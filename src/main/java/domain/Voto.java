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

import org.hibernate.validator.constraints.Range;

// INPUT
@Entity
@Access(AccessType.PROPERTY)
public class Voto extends DomainEntity {

	private Integer cp;

	@NotNull
	@Range(min = 0, max = 52999)
	public Integer getCp() {
		return cp;
	}

	public void setCp(Integer cp) {
		this.cp = cp;
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