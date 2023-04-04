package com.ahson.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncode {
	  @Bean
	  public static PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder(10);
	  }
}
