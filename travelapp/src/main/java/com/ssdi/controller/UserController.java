package com.ssdi.controller;

/**
 * @author ajaykumar
 * 
 * Controller class for
 * User login and registration
 *
 */
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/*import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
*/
import com.ssdi.Authenticate;
import com.ssdi.Create;
import com.ssdi.entity.User;
import com.ssdi.service.ReviewService;
import com.ssdi.service.UserService;

@RestController
public class UserController {

	UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	public UserController() {

	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public User register(@Validated(Create.class) @RequestBody User user) {
		return userService.createUser(user);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User login(@Validated(Authenticate.class) @RequestBody User user, HttpServletResponse response) {

		user = userService.loginUser(user);
		if (user == null) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return null;
		} else {
			user.setSessionId("");
			return user;
		}
	}

	public void setService(UserService service) {
		this.userService = service;
	}
}