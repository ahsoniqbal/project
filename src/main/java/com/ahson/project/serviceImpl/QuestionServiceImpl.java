package com.ahson.project.serviceImpl;

import java.util.List;

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

}
