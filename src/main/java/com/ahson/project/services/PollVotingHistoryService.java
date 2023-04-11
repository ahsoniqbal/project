package com.ahson.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahson.project.models.PollVotingHistory;
import com.ahson.project.repositories.PollVotingHistoryRepo;
import com.ahson.project.services.PollVotingHistoryService;

@Service
public class PollVotingHistoryService {

	@Autowired
	private PollVotingHistoryRepo pollVotingHistoryRepo; 
	
	public PollVotingHistory createPollVotingHistory(PollVotingHistory pollHistory) {
		if(pollHistory!=null) {
			return pollVotingHistoryRepo.save(pollHistory);
		}
		return null;
	}

}
