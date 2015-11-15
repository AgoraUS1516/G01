package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repositories.AnswerRepository;
import domain.Answer;

@Service
@Transactional
public class AnswerService {
	
	// Managed repository -----------------------------------------------------
	
	@Autowired
	private AnswerRepository answerRepository;
	
	// CRUD methods -----------------------------------------------------------
	
	public Answer create() {
		Answer result;
		
		result = new Answer();
		
		return result;
	}
	
	public void save(Answer answer) {
		answerRepository.save(answer);
	}
	
	public void delete(Answer answer) {
		answerRepository.delete(answer);
	}
	
	public Answer findOne(int answerId) {
		answerRepository.findOne(id);
	}
	
	public Collection<Answer> findAll() {
		answerRepository.findAll();
	}

}
