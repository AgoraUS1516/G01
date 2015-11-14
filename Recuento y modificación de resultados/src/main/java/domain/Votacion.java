package domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

//Sustituto de Votos y/o VotosCifrados
@Entity
public class Votacion extends DomainEntity{

	private Integer msg;
	private List<Voto> votes;

	public Integer getMsg() {
		return this.msg;
	}

	public void setMsg(Integer msg) {
		this.msg = msg;
	}
	@OneToMany
	public List<Voto> getVotes() {
		return votes;
	}

	public void setVotes(List<Voto> votes) {
		this.votes = votes;
	}

}
