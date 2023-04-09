package com.ahson.project.services;

import java.util.List;
import java.util.Optional;

import com.ahson.project.models.Question;

public interface QuestionService {
	public List<Question> getAllQuestion();
	public Question createQuestion(Question question);
	public Optional<Question> getQuestion(Long id);
	
}
