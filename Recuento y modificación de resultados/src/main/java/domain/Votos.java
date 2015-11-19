package domain;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
//Sustituido por Votacion

public class Votos {

	private Integer msg;
	

	public Integer getMsg() {
		return this.msg;
	}

	public void setMsg(Integer msg) {
		this.msg = msg;
	}
	// Relationships ----------------------------------------------------------
	private List<Voto> votes;
	
	public List<Voto> getVotes() {
		return votes;
	}

	public void setVotes(List<Voto> votes) {
		this.votes = votes;
	}

}
