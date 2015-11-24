package domain;



import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Access(AccessType.PROPERTY)
public class Opcion extends DomainEntity{
	
	private Integer votos;
	private String opcion;
	
	
	
	public Opcion() {
		super();
	}

	public Integer getVotos() {
		return votos;
	}
	
	public void setVotos(Integer votos) {
		this.votos = votos;
	}
	
	@NotBlank
	public String getOpcion() {
		return opcion;
	}
	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}
	
	// Relationships ----------------------------------------------------------
	private Resultado result;
	private Answer ans;


	@Valid
	@ManyToOne(optional=true)
	public Resultado getResult() {
		return result;
	}

	public void setResult(Resultado result) {
		this.result = result;
	}
	
	@Valid
	@ManyToOne(optional=true)
	public Answer getAns() {
		return ans;
	}

	public void setAns(Answer ans) {
		this.ans = ans;
	}
	
	
}
