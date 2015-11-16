package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

@Entity
@Access(AccessType.PROPERTY)
public class Respuesta extends DomainEntity{

	private String pregunta;
	private int numerosSi;
	private int numerosNo;
	
	//No pueden tener constructores
	/*
	public Respuesta(String question){
		pregunta = question;
		numerosNo = 0;
		numerosSi = 0;
	}
*/
	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public int getNumerosSi() {
		return numerosSi;
	}

	public void setNumerosSi(int numerosSi) {
		this.numerosSi = numerosSi;
	}

	public int getNumerosNo() {
		return numerosNo;
	}

	public void setNumerosNo(int numerosNo) {
		this.numerosNo = numerosNo;
	}

	@Override
	public String toString() {
		return "Respuesta [pregunta=" + pregunta + ", numerosSi=" + numerosSi
				+ ", numerosNo=" + numerosNo + "]";
	}

}
