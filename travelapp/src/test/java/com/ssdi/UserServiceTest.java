package com.ssdi;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.ssdi.service.UserService;
import com.ssdi.entity.User;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TravelWebAppApplication.class)
public class UserServiceTest {

	@Autowired
    private UserService userService;
 
    
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
	}

}
