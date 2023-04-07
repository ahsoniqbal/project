package com.ahson.project.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ahson.project.models.User;
import com.ahson.project.services.UserService;


@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/profile/{id}")
	public String getUser(@PathVariable Integer id, Model model){
		Optional<User> user = userService.getUserById(id);
		if(user == null) return "errors/500"; 
		if(user.isPresent()) {
			model.addAttribute("user", user.get());
			return "users/profile";
		}
		return "errors/404";
	}
	
//	@RequestMapping("/{username}")
//	public ResponseEntity<User> getUser(@PathVariable String username){
//		User user = userService.getUser(username);
//		if(user != null)
//			return new ResponseEntity<User>(user, HttpStatus.OK);
//		
//		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//	}
	
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.addUser(user), HttpStatus.OK);
	}

}
