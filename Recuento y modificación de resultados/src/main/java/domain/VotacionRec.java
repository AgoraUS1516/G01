package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

//OUTPUT
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
	
	private Collection<Recuento> recuento;
	
	@OneToMany(cascade=CascadeType.ALL)
	public Collection<Recuento> getRecuento() {
		return recuento;
	}

	public void setRecuento(Collection<Recuento> recuento) {
		this.recuento = recuento;
	}
	
	


}
