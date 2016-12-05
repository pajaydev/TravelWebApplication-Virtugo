package com.ssdi.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.springframework.mock.web.MockHttpServletResponse;
import com.ssdi.entity.User;
import com.ssdi.service.UserService;



@RunWith(JUnit4.class)
public class UserControllerTest {
	
	@Mock
	private UserService userService;
	
	private UserController userController;
	private User user;
	private User user2;
	private MockHttpServletResponse response;
	
	@Before
	public void setup() throws Exception{
		userController = new UserController();
		userService = mock(UserService.class);
		userController.setService(userService);
		response = new MockHttpServletResponse();
		
		user = new User();
		user.setId(1);
		user.setEmail("abc@gmail.com");
		user.setPassword("xxx");
		
		
		user2 = new User();
		user2.setId(null);
		
		when(userService.findOne(user.getId())).thenReturn(user);
		when(userService.findOne(user2.getId())).thenReturn(null);
		when(userService.createUser(user)).thenReturn(user);
		when(userService.createUser(user2)).thenReturn(null);
		
		
		
	}
	
	@Test
	public void testValidRegister(){
		assertEquals(user, userController.register(user));
	}
	
	
	@Test
	public void testInvalidRegister(){
		assertEquals(null, userController.register(user2));
	}
	
	@Test 
	public void testValidLogin(){
		when(userService.loginUser(user)).thenReturn(user);
		assertEquals(user, userController.login(user, response));
	}
	
	@Test 
	public void testInvalidLogin(){
		
		assertEquals(null, userController.login(user2, response));
	}
	
	

}
