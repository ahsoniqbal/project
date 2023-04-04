package com.ahson.project.services;

import java.util.List;
import java.util.Optional;

import com.ahson.project.models.User;

public interface UserService {
	public List<User> getAll();
	public Optional<User> getUserById(Integer id);
	public User addUser(User user);
}
