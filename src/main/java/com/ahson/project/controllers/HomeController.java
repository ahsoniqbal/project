package com.ahson.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String loadHome() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login/index";
	}
}
