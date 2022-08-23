package com.homeloansystem.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.homeloansystem.authentication.model.User;
import com.homeloansystem.authentication.repository.UserRepository;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping
	@ResponseBody
	public String register() {
		return "Registration Page";
	}
	
	@PostMapping
	@ResponseBody
	public String registerPost(String email, String first_name, String last_name, String password, int role) {
		User user = new User(first_name, last_name, email, password, role);
		userRepo.save(user);
		System.out.println(email + " " + first_name + " " + last_name + " " + password);
		return "Post Register";
	}
	
}
