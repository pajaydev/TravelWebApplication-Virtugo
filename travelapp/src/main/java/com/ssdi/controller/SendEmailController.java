/**
 * 
 */
package com.ssdi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

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
 *         Controller class for Sending Email to registered email and sharing
 *         the email
 *
 */
@RestController
public class SendEmailController {

	EmailService emailService;
	// PlanService planService;
	// UserService userService;

	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(PlanController.class);

	@Autowired
	public SendEmailController(EmailService emailService) {
		super();
		this.emailService = emailService;
		// this.planService = planService;

	}

	public SendEmailController() {

	}

	@Autowired
	PlanService planService;
	@Autowired
	UserService userService;

	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
	public String register(@Validated(Create.class) @RequestBody Plan plan) throws MessagingException {
		StringBuffer body = new StringBuffer();
		List<Plan> list = new ArrayList<Plan>();
		List<Integer> listId = plan.getIdList();

		User user = userService.findOne(plan.getUserId());
		String email = user.getEmail();
		for (Integer planList : listId) {
			list.add(planService.getPlansByPlaceId(planList));
		}
		// List<Plan> list = planService.getPlansById(plan.getUserId());

		/*
		 * for(Plan planDetails:list){
		 * 
		 * body.append("<br />");
		 * body.append("Please find your travel plans below");
		 * body.append("<br />"); body.append("<br />");
		 * body.append("<b>Plan  : </b>"+planDetails.getPlace());
		 * body.append(" <b>Address  :</b> "+planDetails.getAddress());
		 * body.append(" <b>Temperature  :</b> "+planDetails.getClimate());
		 * body.append(" <b>Hotel   :</b> "+planDetails.getHotel());
		 * body.append(" <b>Date Added  :</b>  "+planDetails.getDateAdded());
		 * body.append(" <b>Date of Travel   :</b> "+planDetails.getDateTravel()
		 * ); body.append("<br />"); body.append("<br />"); }
		 */
		body.append("<html>");
		body.append("<body><head><style>" + "table, th, td {" + "	border: 1px solid black;"
				+ "	border-collapse: collapse;" + "}" + "</style></head>");
		body.append("Dear <b>" + user.getUserName() + "</b>");
		body.append("<table>" + " <tr>" + "<th>Plan</th>" + "<th>Hotel</th>" + "<th>Address</th>"
				+ "<th>Temperature</th>" + "<th>Date Added</th>" + "<th>Date of travel</th>" + "</tr>");
		for (Plan planDetails : list) {

			body.append("<tr>");
			body.append("<td>" + planDetails.getPlace() + "</td>" + "<td>" + planDetails.getHotel() + "</td>" + "<td>"
					+ planDetails.getAddress() + "</td>" + "<td>" + planDetails.getClimate() + "</td>" + "<td>"
					+ planDetails.getDateAdded() + "</td>" + "<td>" + planDetails.getDateTravel() + "</td>" + "</tr>");
		}
		body.append("</table>");
		body.append("</body></html>");
		String subject = "Your Plan Confirmation";

		return emailService.sendEmail(email, subject, body.toString());
	}

	@RequestMapping(value = "/shareEmail", method = RequestMethod.POST)
	public String shareEmail(@Validated(Create.class) @RequestBody Plan plan) throws MessagingException {
		String mail = plan.getEmailId();
		List<Plan> list = new ArrayList<Plan>();
		List<Integer> listId = plan.getIdList();
		System.out.println("list**" + listId.size());
		System.out.println(mail);
		StringBuffer body = new StringBuffer();
		User user = userService.findOne(plan.getUserId());
		System.out.println(plan.getUserId());
		for (Integer planList : listId) {
			list.add(planService.getPlansByPlaceId(planList));
		}
		// List<Plan> list = planService.getPlansById(plan.getUserId());
		System.out.println("List" + list.size());

		/*
		 * for(Plan planDetails:list){
		 * 
		 * body.append("<br />");
		 * body.append("Please find the travel plans below");
		 * body.append("<br />"); body.append("<br />");
		 * body.append("<b>Plan  : </b>"+planDetails.getPlace());
		 * body.append(" <b>Address  :</b> "+planDetails.getAddress());
		 * body.append(" <b>Temperature  :</b> "+planDetails.getClimate());
		 * body.append(" <b>Hotel   :</b> "+planDetails.getHotel());
		 * body.append(" <b>Date Added  :</b>  "+planDetails.getDateAdded());
		 * body.append(" <b>Date of Travel   :</b> "+planDetails.getDateTravel()
		 * ); body.append("<br />"); body.append("<br />"); }
		 */
		body.append("<html>");
		body.append("<body><head><style>" + "table, th, td {" + "	border: 1px solid black;"
				+ "	border-collapse: collapse;" + "}" + "</style></head>");
		body.append("Hello!" + " Your friend " + user.getUserName() + " has shared their plans with you!");
		body.append("<table>" + " <tr>" + "<th>Plan</th>" + "<th>Hotel</th>" + "<th>Address</th>"
				+ "<th>Temperature</th>" + "<th>Date Added</th>" + "<th>Date of travel</th>" + "</tr>");
		for (Plan planDetails : list) {

			body.append("<tr>");
			body.append("<td>" + planDetails.getPlace() + "</td>" + "<td>" + planDetails.getHotel() + "</td>" + "<td>"
					+ planDetails.getAddress() + "</td>" + "<td>" + planDetails.getClimate() + "</td>" + "<td>"
					+ planDetails.getDateAdded() + "</td>" + "<td>" + planDetails.getDateTravel() + "</td>" + "</tr>");
		}
		body.append("</table>");
		body.append("</body></html>");

		String subject = "Your Plan Confirmation";

		return emailService.sendEmail(mail, subject, body.toString());
	}

	public void setServices(PlanService planService, UserService userService, EmailService emailService) {
		this.emailService = emailService;
		this.planService = planService;
		this.userService = userService;
	}

	public List<Plan> constructEmail(Plan plan) {

		return null;
	}

}
