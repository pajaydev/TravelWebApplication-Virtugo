package com.ssdi.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import com.ssdi.TravelWebAppApplication;
import com.ssdi.entity.User;
import com.ssdi.service.UserService;


@RunWith(JUnit4.class)
public class UserTest {

	private User user;
	
	@Before
	public void setUp() throws Exception{
		user = new User();
		user.setId(1);
		user.setUserName("test");
		user.setEmail("test@gmail.com");
		user.setPassword("test12");
		user.setSessionId("testID");
	}
	
	@Test
	public void testGetId() {
		assertEquals("1", user.getId().toString());
	}
	
	@Test
	public void testGetUserName() {
		assertEquals("test", user.getUserName());
	}
	
	@Test
	public void testGetPassword() {
		assertEquals("test12", user.getPassword());
	}
	
	@Test
	public void testGetEmail() {
		assertEquals("test@gmail.com", user.getEmail());
	}
	
	@Test
	public void testGetSessionId() {
		assertEquals("testID", user.getSessionId());
	}
	
	/*@Autowired
    private UserService userService;
	
	

	@Test
    public void testValidUserName() throws Exception{
    	boolean exceptionCaught = false;
    	try{
    		userService.createUser(user);
    	}catch(Exception e){
    		exceptionCaught = true;
    	}
    	assertFalse(exceptionCaught);
    }
	
	@Test
    public void testInvalidUserName() throws Exception{
    	
    	boolean exceptionCaught = false;
		try{
			user.setUserName(null);
			userService.createUser(user);
		}
		catch(Exception e){
			exceptionCaught = true;
		}
		assertTrue(exceptionCaught);
    }
	
	@Test
    public void testValidEmail() throws Exception{
    	boolean exceptionCaught = false;
    	try{
    		userService.createUser(user);
    	}catch(Exception e){
    		exceptionCaught = true;
    	}
    	assertFalse(exceptionCaught);
    }
  
    @Test
    public void testInvalidEmail() throws Exception{
    	
    	boolean exceptionCaught = false;
		try{
			user.setEmail(null);
			userService.createUser(user);
		}
		catch(Exception e){
			exceptionCaught = true;
		}
		assertTrue(exceptionCaught);
    }
    
    @Test
    public void testValidPassword() throws Exception{
    	boolean exceptionCaught = false;
    	try{
    		userService.createUser(user);
    	}catch(Exception e){
    		exceptionCaught = true;
    	}
    	assertFalse(exceptionCaught);
    }
  
    @Test
    public void testInvalidPassword() throws Exception{
    	
    	boolean exceptionCaught = false;
		try{
			user.setPassword(null);
			userService.createUser(user);
		}
		catch(Exception e){
			exceptionCaught = true;
		}
		assertTrue(exceptionCaught);
    }
    
    @Test
    public void testValidSessionId() throws Exception{
    	boolean exceptionCaught = false;
    	try{
    		userService.createUser(user);
    	}catch(Exception e){
    		exceptionCaught = true;
    	}
    	assertFalse(exceptionCaught);
    }
*/  
    
}
