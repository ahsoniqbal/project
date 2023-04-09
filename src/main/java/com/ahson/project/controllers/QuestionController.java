package com.ahson.project.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
			Optional<Question> questionOptional = questionService.getQuestion(id);
			if(questionOptional.isEmpty()) return "errors/404";
			Question question = questionOptional.get();
			model.addAttribute("ques", question);
			return "questions/view";
		}
		return "errors/404";
	}
	
}
