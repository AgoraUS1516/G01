package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public class RecuentoOpcion extends DomainEntity {

	private int cP;
	private int cantidadVotos;

	public int getcP() {
		return cP;
	}

	public void setcP(int cP) {
		this.cP = cP;
	}

	public int getCantidadVotos() {
		return cantidadVotos;
	}

	public void setCantidadVotos(int cantidadVotos) {
		this.cantidadVotos = cantidadVotos;
	}

	// Relationships ----------------------------------------

	private OpcionRec opcionRec;

	@Valid
	@ManyToOne(optional = false)
	public OpcionRec getOpcionRec() {
		return opcionRec;
	}

	public void setOpcionRec(OpcionRec opcionRec) {
		this.opcionRec = opcionRec;
	}

}
