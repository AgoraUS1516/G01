package domain;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
//Sustituido por Votacion

public class VotosCifrados {

	private Integer msg;
	private List<String> encryptedVotes;

	public Integer getMsg() {
		return this.msg;
	}

	public void setMsg(Integer msg) {
		this.msg = msg;
	}

	public List<String> getVotes() {
		return encryptedVotes;
	}

	public void setVotes(List<String> votes) {
		this.encryptedVotes = votes;
	}

}
