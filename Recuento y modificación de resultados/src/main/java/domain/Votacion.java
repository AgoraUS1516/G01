package domain;


import java.util.Collection;

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
	private String identificator;
	

	public Integer getMsg() {
		return this.msg;
	}

	public void setMsg(Integer msg) {
		this.msg = msg;
	}
	
	
	@NotNull
	public String getIdentificator() {
		return identificator;
	}

	public void setIdentificator(String identificator) {
		this.identificator = identificator;
	}



	// Relationships ----------------------------------------------------------
	private Collection<Resultado> resultados;
	private Collection<Voto> votos;
	
	@NotNull
	@Valid
	@OneToMany(mappedBy="votacion")
	public Collection<Resultado> getResultados() {
		return resultados;
	}

	public void setResultados(Collection<Resultado> resultados) {
		this.resultados = resultados;
	}
	
	@NotNull
	@Valid
	@OneToMany(mappedBy="votacion")
	public Collection<Voto> getVotos() {
		return votos;
	}

	public void setVotos(Collection<Voto> votos) {
		this.votos = votos;
	}
	
	
	
	
	

	
	


}
