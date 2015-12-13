package domain;


import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

// INPUT
@Entity
@Access(AccessType.PROPERTY)
public class Votacion extends DomainEntity {
	
	public String nombre; 
	
	@NotBlank
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	// Relationships ----------------------------------------
	private Collection<Voto> votos;

	@NotNull
	@Valid
	@OneToMany(mappedBy = "votacion")
	public Collection<Voto> getVotos() {
		return votos;
	}

	public void setVotos(Collection<Voto> votos) {
		this.votos = votos;
	}

}
