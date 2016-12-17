package com.ssdi.service;

/**
 * @author ajaykumar
 * 
 * Service class for
 * Sending Email to registered email
 * and sharing the email
 *
 */
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public String sendEmail(String to, String subject, String body) throws MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;

		helper = new MimeMessageHelper(message, true);
		// helper.setText(html, "utf-8", "html").
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(body, true); // true = html

		javaMailSender.send(message);
		return "success";

	}

}
