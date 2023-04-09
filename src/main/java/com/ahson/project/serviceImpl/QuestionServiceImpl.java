package com.ahson.project.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahson.project.models.Question;
import com.ahson.project.repositories.QuestionRepo;
import com.ahson.project.services.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepo questionRepo;
	
	@Override
	public List<Question> getAllQuestion() {
		return questionRepo.findAll();
	}

	@Override
	public Question createQuestion(Question question) {
		if(question == null) return null;
		return questionRepo.save(question);
	}

	@Override
	public Optional<Question> getQuestion(Long id) {
		if(id == null) return Optional.empty();
		return questionRepo.findById(id);
	}

}
