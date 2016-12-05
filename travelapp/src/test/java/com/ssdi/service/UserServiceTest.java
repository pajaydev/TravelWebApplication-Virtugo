package com.ssdi.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import com.ssdi.repository.UserRepository;
import com.ssdi.service.UserService;
import com.ssdi.entity.User;


@RunWith(JUnit4.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;
	
	private User user;
	private User user2;
	private UserService userService;
	
	
	
	@Before
	public void setup() throws Exception{
		userService = new UserService();
		userRepository = mock(UserRepository.class);
		userService.setReviewRepository(userRepository);;
		user = new User();
		user.setId(1);
		user.setEmail("abc@gmail.com");
		user.setPassword("xxx");
		
		user2 = new User();
		user2.setId(null);
		
		
		
		when(userRepository.findOne(user.getId())).thenReturn(user);
		when(userRepository.findOne(user2.getId())).thenReturn(null);
		when(userRepository.save(user)).thenReturn(user);
		when(userRepository.save(user2)).thenReturn(null);
		
		
	}
	
	@Test
	public void testValidCreateUser(){
		
		assertEquals(user, userService.createUser(user));
	}
	
	
	@Test
	public void testInvalidCreateUser(){
		
		assertEquals(null, userService.createUser(user2));
	}
	
	@Test
	public void testValidLoginUser(){
		when(userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword())).thenReturn(user);
		assertEquals(user, userService.loginUser(user));
	}
	
	@Test
	public void testInvalidLoginUser(){
		assertEquals(null, userService.loginUser(user2));
	}
	
	@Test
	public void testValidFindOne(){
		assertEquals(user, userService.findOne(user.getId()));
	}
	
	@Test
	public void testInValidFindOne(){
		assertEquals(null, userService.findOne(user2.getId()));
	}
	
	
	
	
	
	
 
   /* 
	@Test
	public void testValidGetUserById() throws Exception {
		boolean condition = false;
		User r = userService.findOne(1);
		System.out.println(r.getEmail());
		if (r.getId() == 1)
			condition = true;
		assertTrue(condition);
	}

	@Test
	public void testInvalidGetUserById() throws Exception {
		boolean condition = false;
		if (userService.findOne(0) == null)
			condition = true;
		assertTrue(condition);
	}
	
	@Test
	public void testValidAddUser() throws Exception{
		boolean condition = false;
		User user = new User();
		
		user.setUserName("test");
		user.setEmail("Hello@test.com");
		user.setPassword("test");
		//user.setSessionId("1231");
		User r = userService.createUser(user);
		User response = userService.findOne(r.getId());
		if (r.getId().equals(response.getId()))
			condition = true;
		assertTrue(condition);
	}
	
	@Test
	public void testInvalidAddUser() throws Exception{
		boolean condition = false;
		User user = new User();
		try {
			userService.createUser(user);
		} catch (Exception e) {
			condition = true;
		}
		assertTrue(condition);
	}
	
	@Test
	public void testValidSignIn() throws Exception{
		boolean condition = false;
		User user = userService.findOne(1);
		User user1 = userService.loginUser
				(user);
		if (user1.getId().equals(user.getId()))
			condition = true;
		assertTrue(condition);
	}
	
	@Test
	public void testInvalidSignIn() throws Exception{
		boolean condition = false;
		User user = new User();
		User response= userService.loginUser(user);
		if(response == null)
			condition = true;
		assertTrue(condition);
	} */

}
