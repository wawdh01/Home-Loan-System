package com.homeloansystem.authentication.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.homeloansystem.authentication.model.User;
import com.homeloansystem.authentication.repository.UserRepository;
import com.homeloansystem.authentication.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	UserService usrService;
	
	@GetMapping
	@ResponseBody
	public String login() {
		return "Welcome";
	}
	
	@PostMapping
	@ResponseBody
	public String loginPost(String email, String password, HttpServletResponse response) {
		System.out.println(email + " " + password);
		String result = usrService.loginService(email, password);
		if (result == "Signed In") {
			Cookie cookie = new Cookie("email", email);
			response.addCookie(cookie);
		}
		return result;
		
	}
	
	//Examples to Check
	@GetMapping("/a")
	@ResponseBody
	public String a(@RequestHeader Map<String, String> headers) {
		String cookie = headers.get("cookie");
		if (cookie == null) {
			return "Not Validated";
		}
		else {
			System.out.println(cookie);
			return "validated";
		}
	}
}
