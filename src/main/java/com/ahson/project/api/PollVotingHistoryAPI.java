package com.ahson.project.api;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ahson.project.models.PollVotingHistory;
import com.ahson.project.models.ResponseWrapper;
import com.ahson.project.models.User;
import com.ahson.project.security.MyUserDetails;
import com.ahson.project.services.PollVotingHistoryService;

@RestController
public class PollVotingHistoryAPI {

	@Autowired
	private PollVotingHistoryService pollVotingHistoryService;
	
	@PostMapping("/questions/vote")
	public ResponseEntity<ResponseWrapper> create(@AuthenticationPrincipal MyUserDetails user, @RequestBody PollVotingHistory pollHistory){
		
		if(user!=null) {
			System.out.println(pollHistory);
			pollHistory.setUser(user.getUser());
			pollHistory.setCreatedAt(new Date());
			PollVotingHistory pollModel =  pollVotingHistoryService.createPollVotingHistory(pollHistory);
			
			return new ResponseEntity<>(new ResponseWrapper(200, "created", pollModel), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(new ResponseWrapper(0, "Unauthorized"), HttpStatus.UNAUTHORIZED);
		
	}
	
}
