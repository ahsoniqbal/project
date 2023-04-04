package com.ahson.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.ahson.project.security.MyUserDetailsService;


@Configuration
public class SecurityConfig {
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
        	.authorizeHttpRequests((authz) -> authz
        			.antMatchers("/questions/ask").authenticated()
        		//	.antMatchers("/","/home","/login","/register").permitAll()
        			.antMatchers("/**").permitAll()
//        			.anyRequest()
//        		.authenticated()
        )
        	.userDetailsService(myUserDetailsService)
        .formLogin()
		.loginPage("/login")
		.usernameParameter("email")
		.defaultSuccessUrl("/");
		
		return http.build();	
	}
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	  return new BCryptPasswordEncoder(10);
	}
}
