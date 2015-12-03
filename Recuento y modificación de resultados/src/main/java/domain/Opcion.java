package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public class Opcion extends DomainEntity {

	// Relationships ----------------------------------------
	private Voto voto;

	@Valid
	@ManyToOne(optional = false)
	public Voto getPreguntaRec() {
		return voto;
	}

	public void setPreguntaRec(Voto voto) {
		this.voto = voto;
	}

}
