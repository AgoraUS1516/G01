package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;
// Test Commit
@Entity
@Access(AccessType.PROPERTY)
public class Answer extends DomainEntity{

	private String question;
	private String answer_question;

	@NotBlank
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@NotBlank
	public String getAnswer_question() {
		return answer_question;
	}

	public void setAnswer_question(String answer_question) {
		this.answer_question = answer_question;
	}

	@Override
	public String toString() {
		return "Answer [question=" + question + ", answer_question="
				+ answer_question + "]";
	}

}

