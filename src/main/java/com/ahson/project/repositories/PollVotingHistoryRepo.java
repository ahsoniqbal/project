package com.ahson.project.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ahson.project.models.PollVotingHistory;

public interface PollVotingHistoryRepo extends CrudRepository<PollVotingHistory, Long>{
	
}
