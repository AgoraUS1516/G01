package domain;



import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
	private Resultado resultado;
	private Answer answer;


	@Valid
	@NotNull
	@ManyToOne(optional=false)
	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado result) {
		this.resultado = result;
	}
	
	@Valid
	@NotNull
	@ManyToOne(optional=false)
	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer ans) {
		this.answer = ans;
	}
	
	
}
