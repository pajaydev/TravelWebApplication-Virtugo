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
	//PlanService planService;
	//UserService userService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PlanController.class);
	
	@Autowired
	public SendEmailController(EmailService emailService) {
		super();
		this.emailService = emailService;
		//this.planService = planService;
		
	}
	@Autowired
	PlanService planService;
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
	public String register(@Validated(Create.class) @RequestBody Plan plan) throws MessagingException {
		System.out.println("*******Inside Send Email*********");
		System.out.println("Email"+plan.getUserId());
		StringBuffer body = new StringBuffer();
		User user = userService.findOne(plan.getUserId());
		String email = user.getEmail();
		
		List<Plan> list = planService.getPlansById(plan.getUserId());
		System.out.println("List"+list.size());
		
		for(Plan planDetails:list){
			body.append("Plan  :"+planDetails.getPlace());
			body.append("Address  :"+planDetails.getAddress());
			body.append("Temperature  :"+planDetails.getClimate());
			body.append("Hotel   :"+planDetails.getHotel());
			body.append("Date Added   :"+planDetails.getDateAdded());
			body.append("Date of Travel   :"+planDetails.getDateTravel());
		}
		String subject = "Your Plan Confirmation";
	    
		
		return emailService.sendEmail(email,subject,body.toString());
	}
    
	
	public List<Plan> constructEmail(Plan plan){
		
		
		return  null;
	}
	
	
}
