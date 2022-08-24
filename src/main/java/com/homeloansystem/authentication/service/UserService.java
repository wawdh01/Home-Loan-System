package com.homeloansystem.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeloansystem.authentication.model.User;
import com.homeloansystem.authentication.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository usrRepo;
	
	public String registerService(String first_name, String last_name, String email, String password, int role) {
		User user = new User(first_name, last_name, email, password, role);
		usrRepo.save(user);
		return "Registered";
	}
	
	public String loginService(String email, String password) {
		User user = usrRepo.findByEmail(email);
		System.out.println(user);
		if (user == null) {
			return "You haven't registerd yet";
		}
		else {
			if (password.equals(user.getPassword())) {
				return "Signed In";
			}
			else {
				return "Email or Password is wrong";
			}
		}
	}
}
