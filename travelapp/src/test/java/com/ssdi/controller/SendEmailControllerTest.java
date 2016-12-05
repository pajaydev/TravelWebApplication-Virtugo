package com.ssdi.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;

import com.ssdi.entity.Plan;
import com.ssdi.entity.User;
import com.ssdi.service.EmailService;
import com.ssdi.service.PlanService;
import com.ssdi.service.UserService;

@RunWith(JUnit4.class)
public class SendEmailControllerTest {
	
	@Mock
	private EmailService emailService;
	
	@Mock
	private UserService userService;
	
	@Mock 
	private PlanService planService;

	private SendEmailController controller;
	private Plan plan;
	private User user;
	private List<Plan> plans;
 	
	@Before
	public void setup() {
		controller = new SendEmailController();
		emailService = mock(EmailService.class);
		planService = mock(PlanService.class);
		userService = mock(UserService.class);
		controller.setServices(planService, userService, emailService);
		plans = new ArrayList<Plan>();
		plan = new Plan();
		user = new User();
		
		user.setEmail("aa@a.com");
		user.setId(1);
		user.setUserName("abc");
	
		plan.setAddress("India");
		plan.setClimate("Winter");
		plan.setDateAdded(new java.sql.Date(new Date().getTime()));
		plan.setDateTravel(new java.sql.Date(new Date().getTime()));
		plan.setHotel("Taj");
		plan.setPlace("Mumbai");
		plan.setUserId(1);
		plans.add(plan);
		
		StringBuffer body = new StringBuffer();
		body.append("Dear <b>"+ user.getUserName()+"</b>");
		body.append("<br />");
		body.append("Please find your travel plans below");
		body.append("<br />");
		body.append("<br />");
		body.append("<b>Plan  : </b>"+plan.getPlace());
		body.append(" <b>Address  :</b> "+plan.getAddress());
		body.append(" <b>Temperature  :</b> "+plan.getClimate());
		body.append(" <b>Hotel   :</b> "+plan.getHotel());
		body.append(" <b>Date Added  :</b>  "+plan.getDateAdded());
		body.append(" <b>Date of Travel   :</b> "+plan.getDateTravel());
		body.append("<br />");
		body.append("<br />");
		
		String subject = "Your Plan Confirmation";
		try {
			System.out.println("Inside try method");
			when(emailService.sendEmail(user.getEmail(), subject, body.toString())).thenReturn("Success");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		when(userService.findOne(plan.getUserId())).thenReturn(user);
		when(planService.getPlansById(plan.getUserId())).thenReturn(plans);
		
	}
	
	@Test
	public void testSendEmail(){
		try {
			assertEquals("Success", controller.register(plan));
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
		
}

