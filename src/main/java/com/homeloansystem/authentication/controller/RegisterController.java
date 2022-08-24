package com.homeloansystem.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.homeloansystem.authentication.model.User;
import com.homeloansystem.authentication.repository.UserRepository;
import com.homeloansystem.authentication.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	UserService usrService;
	
	@GetMapping
	@ResponseBody
	public String register() {
		return "Registration Page";
	}
	
	@PostMapping
	@ResponseBody
	public String registerPost(String email, String first_name, String last_name, String password, int role) {
		String result = usrService.registerService(first_name, last_name, email, password, role);
		return result;
	}
	
}
