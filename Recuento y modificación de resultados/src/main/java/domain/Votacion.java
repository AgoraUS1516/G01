package domain;

import java.util.Collection;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

//Sustituto de Votos y/o VotosCifrados
@Entity
@Access(AccessType.PROPERTY)
public class Votacion extends DomainEntity{

	private Integer msg;
	

	public Integer getMsg() {
		return this.msg;
	}

	public void setMsg(Integer msg) {
		this.msg = msg;
	}
	
	// Relationships ----------------------------------------------------------
	private List<Resultado> resultados;
	
	@NotNull
	@Valid
	@OneToMany(mappedBy="votacion")
	public List<Resultado> getResultados() {
		return resultados;
	}

	public void setResultados(List<Resultado> resultados) {
		this.resultados = resultados;
	}

	
	


}
