package com.ahson.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ahson.project.models.Poll;
import com.ahson.project.models.Question;
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
			return "questions/view";
		}
		return "errors/500";

	}
	
	@GetMapping("/questions/ask")
	public String askPage(@ModelAttribute("ques") Question question) {
		
		return "questions/insert";
	}
	
	@PostMapping("/questions")
	public String ask(@ModelAttribute("ques") Question question) {
		return "questions/insert";
	}
	
	
//	@PostMapping("/questions/ask")
//	public String addQuestion(@ModelAttribute("quest") Question question, Model model) {
//		model.addAttribute("success", "Question Added");
//		System.out.println(question.getQuestion());
//		System.out.println(question.getPolls().get(0).getBody());
//		
//		return "redirect:/questions/ask";
//	}

}
