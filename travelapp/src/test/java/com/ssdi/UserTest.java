package com.ssdi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.ssdi.TravelWebAppApplication;
import com.ssdi.entity.User;
import com.ssdi.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TravelWebAppApplication.class)
public class UserTest {

	private User user;
	
	@Autowired
    private UserService userService;
	
	@Before
	public void setUp() throws Exception{
		user = new User();
		user.setUserName("test");
		user.setEmail("test@gmail.com");
		user.setPassword("test12");
		user.setSessionId("testID");
	}

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
  
    
}
