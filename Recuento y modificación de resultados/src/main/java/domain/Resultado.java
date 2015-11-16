package domain;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;



@Entity
@Access(AccessType.PROPERTY)
public class Resultado extends DomainEntity{
	String pregunta;
	Integer numeroSi;
	Integer numeroNo;
	
	public Resultado(){
		super();
	}
	/*
	public Resultado(String pregunta, Integer numeroSi, Integer numeroNo) {
		super();
		this.pregunta = pregunta;
		this.numeroSi = numeroSi;
		this.numeroNo = numeroNo;
	}
	*/
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public Integer getNumeroSi() {
		return numeroSi;
	}
	public void setNumeroSi(Integer numeroSi) {
		this.numeroSi = numeroSi;
	}
	public Integer getNumeroNo() {
		return numeroNo;
	}
	public void setNumeroNo(Integer numeroNo) {
		this.numeroNo = numeroNo;
	}
	
	// Relationships ----------------------------------------------------------
	private Votacion votacion;
		
	
	@Valid
	@ManyToOne(optional=true)
	public Votacion getVotacion() {
		return votacion;
	}

	public void setVotacion(Votacion votacion) {
		this.votacion = votacion;
	}
	
	
}
