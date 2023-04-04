package com.ahson.project.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ahson.project.models.Poll;


public interface PollRepo extends CrudRepository<Poll, Integer>{

}
