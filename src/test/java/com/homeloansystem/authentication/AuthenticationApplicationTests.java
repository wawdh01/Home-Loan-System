package com.homeloansystem.authentication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.homeloansystem.authentication.model.User;
import com.homeloansystem.authentication.repository.UserRepository;
import com.homeloansystem.authentication.service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class AuthenticationApplicationTests {

	@MockBean
	UserRepository usrRepo;
	
	@Autowired
	UserService usrService;
	
	@Test
	public void loginServiceTest() {
		User user = new User("Test_FirstName", "Test_FinalName", "test@gmail.com", "Test123", 1);
		when(usrRepo.findByEmail("test@gmail.com")).thenReturn(user);
		assertEquals("Signed In", usrService.loginService("test@gmail.com", "Test123")); 
	}
	
	@Test
	void contextLoads() {
		User usr = new User("A", "B", "abcd@gmail.com", "1234", 1);
		assertEquals("A", usr.getFirstName());
		assertEquals("B", usr.getLastName());
		assertEquals("abcd@gmail.com", usr.getEmail());
		assertEquals("1234", usr.getPassword());
		assertEquals(1, usr.getRole());
	}
	
	@Test
	public void registerServiceTest() {
		User user = new User("Test_FirstName", "Test_FinalName", "test@gmail.com", "Test123", 1);
		when(usrRepo.save(user)).thenReturn(user);
		assertEquals("Registered", usrService.registerService("Test_FirstName", "Test_FinalName", "test@gmail.com", "Test123", 1));
	}
	
	@Test
	public void loginServiceTest_Fail1() {
		User user = new User("Test_FirstName", "Test_FinalName", "test123@gmail.com", "Test123", 1);
		when(usrRepo.findByEmail("test123@gmail.com")).thenReturn(user);
		assertEquals("You haven't registerd yet", usrService.loginService("test@gmail.com", "Test123")); 
	}
	
	@Test
	public void loginServiceTest_Fail2() {
		User user = new User("Test_FirstName", "Test_FinalName", "test123@gmail.com", "Test1234", 1);
		when(usrRepo.findByEmail("test@gmail.com")).thenReturn(user);
		assertEquals("Email or Password is wrong", usrService.loginService("test@gmail.com", "Test123")); 
	}

}
