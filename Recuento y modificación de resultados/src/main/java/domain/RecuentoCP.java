package domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

// OUTPUT
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
