package com.ahson.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ahson.project.models.User;
import com.ahson.project.repositories.UserRepo;
import com.ahson.project.services.UserService;

@Service
public class UserService{
	
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public List<User> getAll(){
		return userRepo.findAll();
	}
	
	public Optional<User> getUserById(Integer id) {
		if(id!=null) {
			return userRepo.findById(id);
		}
		return null;
	}
	
	public User addUser(User user) {	
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}
}
