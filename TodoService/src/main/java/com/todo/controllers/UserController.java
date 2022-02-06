package com.todo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.entities.Users;
import com.todo.exceptions.AbstractErrorResponse;
import com.todo.repositories.UserRepository;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserRepository userRepo;

	@PostMapping("/user/login")
	public AbstractErrorResponse login(@RequestBody Users user){
		AbstractErrorResponse response = new AbstractErrorResponse();
		Optional<Users> userInfoOpt = userRepo.findByUserNameAndPassword(user.getUserName(), user.getPassword());
		if(userInfoOpt.isPresent()) {
			return userInfoOpt.get();
//			response.setStatusCode(HttpStatus.ACCEPTED);
//			response.setDescription("User Authenticated");
		} else {
			response.setStatusCode(HttpStatus.FORBIDDEN);
			response.setDescription("Invalid Credentials");
		}
		return response;
	}
}
