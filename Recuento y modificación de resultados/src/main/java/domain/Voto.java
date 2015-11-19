package domain;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Voto extends DomainEntity{
	
	private String age;
	
	private String autonomous_community;
	private String genre;
	private String id_poll;

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	@NotBlank
	public String getAutonomous_community() {
		return autonomous_community;
	}

	public void setAutonomous_community(String autonomous_community) {
		this.autonomous_community = autonomous_community;
	}
	
	@NotBlank
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@NotNull
	public String getId_poll() {
		return id_poll;
	}

	public void setId_poll(String id_poll) {
		this.id_poll = id_poll;
	}

	@Override
	public String toString() {
		return "Voto [age=" + age + ", answers=" + answers
				+ ", autonomous_community=" + autonomous_community + ", genre="
				+ genre + ", id=" + super.getId() + ", id_poll=" + id_poll + "]";
	}
	// Relationships ----------------------------------------------------------
	private List<Answer> answers;
	
	@NotNull
	@Valid
	@OneToMany
	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	

}