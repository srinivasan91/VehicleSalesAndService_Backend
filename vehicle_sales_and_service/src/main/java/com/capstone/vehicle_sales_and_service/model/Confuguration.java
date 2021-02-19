package com.capstone.vehicle_sales_and_service.model;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class Confuguration {
	
	
	@Value("${spring.mail.password}")
	private String mailPwd;
	
	@Value("${spring.mail.username}")
	private String mailUsername;

	public Confuguration() {
	}

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);

		mailSender.setUsername(mailUsername);
		mailSender.setPassword(mailPwd);

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		return mailSender;
	}

	@Bean
	public SimpleMailMessage emailTemplate() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("prawin609@gmail.com");
		message.setFrom(mailUsername);
		message.setText(
				"<h1 color=red>Welcome the CAPSTONE Vehicle Sales and Service Project<h1>...</br></br></br></br><b>This is Auto Generated Mail..Please Do not Reply..!!</b>");
		return message;
	}

}
