/**
 * 
 */
package com.ssdi.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssdi.Create;
import com.ssdi.entity.Plan;
import com.ssdi.entity.User;
import com.ssdi.service.EmailService;
import com.ssdi.service.PlanService;
import com.ssdi.service.UserService;

/**
 * @author ajaykumar
 *
 */
@RestController
public class SendEmailController {

	EmailService emailService;
	PlanService planService;
	UserService userService;
	private static final Logger LOGGER = LoggerFactory.getLogger(PlanController.class);
	
	@Autowired
	public SendEmailController(EmailService emailService) {
		super();
		this.emailService = emailService;
	}
	
	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
	public String register(@Validated(Create.class) @RequestBody Plan plan) throws MessagingException {
		System.out.println("*******Inside Send Email*********");
		System.out.println("Email"+plan.getUserId());
		//user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		//System.out.println("*********Encrypted"+user.getPassword());
		User user = userService.findOne(plan.getUserId());
		System.out.println("**EMAIL**"+user.getEmail());
		planService.getPlansById(plan.getUserId());
		//String email = user.getEmail();
		constructEmail(plan);
		String subject = "Your Plan Confirmation";
	    
		
		return emailService.sendEmail("",subject,"");
	}
    
	
	public List<Plan> constructEmail(Plan plan){
		
		
		return  null;
	}
	
	
}
