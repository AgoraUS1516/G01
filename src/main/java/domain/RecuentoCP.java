package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

// OUTPUT
@Entity
@Access(AccessType.PROPERTY)
public class RecuentoCP extends Recuento{
	
	private Integer cp;
	
	@NotNull
	@Range(min = 0, max = 53000, message = "noEsUnCodigoPostalValido")
	public Integer getCp() {
		return cp;
	}

	public void setCp(Integer cp) {
		this.cp = cp;
	}
	
	
	

}
