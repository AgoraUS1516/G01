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
public class OpcionRec extends DomainEntity {

	private String opcion;

	@NotBlank
	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	// Relationships ----------------------------------------

	private Collection<RecuentoOpcion> recuentoOpciones;
	private PreguntaRec preguntaRec;

	@NotNull
	@Valid
	@OneToMany(mappedBy = "opcionRec", cascade = CascadeType.ALL)
	public Collection<RecuentoOpcion> getRecuentoOpciones() {
		return recuentoOpciones;
	}

	public void setRecuentoOpciones(Collection<RecuentoOpcion> recuentoOpciones) {
		this.recuentoOpciones = recuentoOpciones;
	}

	@Valid
	@ManyToOne(optional = false)
	public PreguntaRec getPreguntaRec() {
		return preguntaRec;
	}

	public void setPreguntaRec(PreguntaRec preguntaRec) {
		this.preguntaRec = preguntaRec;
	}

}
