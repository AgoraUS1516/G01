package domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

//Sustituto de Votos y/o VotosCifrados
@Entity
public class Votacion extends DomainEntity{

	private Integer msg;
	private List<Resultado> resultados;

	public Integer getMsg() {
		return this.msg;
	}

	public void setMsg(Integer msg) {
		this.msg = msg;
	}
	@OneToMany
	public List<Resultado> getResultados() {
		return resultados;
	}

	public void setResultados(List<Resultado> resultados) {
		this.resultados = resultados;
	}



}
