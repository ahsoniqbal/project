package com.ahson.project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ahson.project.models.Question;

public interface QuestionRepo extends CrudRepository<Question, Long>{
	 public List<Question> findAll();
}
