package com.ahson.project.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ahson.project.models.Choice;
import com.ahson.project.models.Question;
import com.ahson.project.models.ResponseWrapper;
import com.ahson.project.models.User;
import com.ahson.project.security.MyUserDetails;
import com.ahson.project.services.QuestionService;

@RestController
public class QuestionAPI {

	@Autowired
	private QuestionService questionService;
	
	
	@PostMapping("/questions")
	public ResponseEntity<ResponseWrapper> askQuestion(@AuthenticationPrincipal MyUserDetails user, @RequestBody Question question){
		Question q = new Question();
		
		if(question != null) {
			question.setAskedBy(user.getUser());
			question.setPostedOn(new Date());

			questionService.createQuestion(question);
			
			System.out.println(question);
			
			return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(201,"User Created", question), HttpStatus.CREATED);
		}
		return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(0, "Exception occured"), HttpStatus.FORBIDDEN);
	}
	
	@PostMapping("/questions/options")
	public ResponseEntity<ResponseWrapper> addOption(@AuthenticationPrincipal MyUserDetails user, @RequestBody Question question){
		Question q = new Question();
		
		if(question != null) {
			question.setAskedBy(user.getUser());
			question.setPostedOn(new Date());

			questionService.createQuestion(question);
			
			System.out.println(question);
			
			return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(201,"User Created", question), HttpStatus.CREATED);
		}
		return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(0, "Exception occured"), HttpStatus.FORBIDDEN);
	}
	
}
