package com.ahson.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.ahson.project.dto.QuestionResponse;
import com.ahson.project.exceptions.ResourceNotFoundException;
import com.ahson.project.models.Question;
import com.ahson.project.repositories.QuestionRepo;
import com.ahson.project.services.QuestionService;

@Service
public class QuestionService  {

	@Autowired
	private QuestionRepo questionRepo;
	
	public List<Question> getAllQuestion() {
		return questionRepo.findAll();
	}

	public Question createQuestion(Question question) {
		if(question == null) return null;
		return questionRepo.save(question);
	}

	public QuestionResponse getQuestion(Long id, UserDetails user) {
		questionRepo.findById(id).orElseThrow( () -> new ResourceNotFoundException("Question", "ID", id));
		
		return null;
	}

}
