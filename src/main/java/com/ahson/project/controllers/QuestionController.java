package com.ahson.project.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.ahson.project.dto.QuestionResponse;
import com.ahson.project.models.Question;
import com.ahson.project.security.MyUserDetails;
import com.ahson.project.services.QuestionService;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;

	@GetMapping("/questions")
	public String getAll(Model model) {
		List<Question> questions = questionService.getAllQuestion();
		if(questions!=null) {
			model.addAttribute("ques", questions);
			return "questions/list";
		}
		return "errors/500";
	}
	
	@GetMapping("/questions/ask")
	public String askPage(@ModelAttribute("ques") Question question) {
		return "questions/insert";
	}
	
	@GetMapping("/questions/{id}")
	public String getQuestion(@PathVariable Long id, Model model) {
		if(id!=null) {
			//QuestionResponse  question = questionService.getQuestion(id);
			
			//model.addAttribute("ques", question);
			return "questions/view";
		}
		return "errors/404";
	}
	
}
