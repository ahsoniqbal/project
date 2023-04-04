package com.ahson.project.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahson.project.models.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	public Optional<User> findByEmail(String email);
}
