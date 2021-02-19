package com.capstone.vehicle_sales_and_service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
 
@Service("emailService")
public class EmailService 
{
    @Autowired
    private JavaMailSender mailSender;
      
    @Autowired
    private SimpleMailMessage preConfiguredMessage;
    
	@Value("${spring.mail.password}")
	private String mailPwd;
	
	@Value("${spring.mail.username}")
	private String mailUsername;
  
    /**
     * This method will send compose and send the message 
     * */
    public void sendMail(String to, String subject, String body) 
    {
    	
        MimeMessagePreparator mailMessage = mimeMessage -> {

            MimeMessageHelper message = new MimeMessageHelper(
                    mimeMessage, true);
            try {
                message.setFrom(mailUsername);
                message.addTo(to);
                message.setSubject(subject);
                message.setText("<h1 color=blue> Welcome to the Vechicle Sales and Service - capstone </br> </h1>"+ body, true);
            } catch (Exception e) {
                System.out.println("Error Occurred... "+ e);
            }
        };
        mailSender.send(mailMessage);
    }
  
    /**
     * This method will send a pre-configured message
     * */
    public void sendPreConfiguredMail(String message) 
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }
}