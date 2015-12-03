package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class VotacionRec extends DomainEntity {

	private String nombre;
	private Date ultimaModififacion;

	@NotBlank
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Past
	@NotNull
	public Date getUltimaModififacion() {
		return ultimaModififacion;
	}

	public void setUltimaModififacion(Date ultimaModififacion) {
		this.ultimaModififacion = ultimaModififacion;
	}

	// Relationships ----------------------------------------

	private Collection<PreguntaRec> preguntaRecs;

	@NotNull
	@Valid
	@OneToMany(mappedBy = "votacionRec", cascade = CascadeType.ALL)
	public Collection<PreguntaRec> getPreguntaRecs() {
		return preguntaRecs;
	}

	public void setPreguntaRecs(Collection<PreguntaRec> preguntaRecs) {
		this.preguntaRecs = preguntaRecs;
	}

}
