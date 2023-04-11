package com.ahson.project.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ahson.project.models.Choice;


public interface PollRepo extends CrudRepository<Choice, Integer>{

}
