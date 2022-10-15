package com.api.scania.api.scania.service;

import com.api.scania.api.scania.model.EmailModel;
import com.api.scania.api.scania.model.StatusEmail;
import com.api.scania.api.scania.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class EmailService {

	@Autowired
	private EmailRepository emailRepository;
	
	@Autowired
	private JavaMailSender emailSender;


	public EmailModel sendEmail(EmailModel model) {
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String data = localDateTime.format(formatter);
		model.setSendDateEmail(data);
		
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(model.getEmailFrom());
			message.setTo(model.getEmailTo());
			message.setSubject(model.getSubject());
			message.setText(model.getText());
			emailSender.send(message);
			model.setStatusEmail(StatusEmail.SEND);
			
		}catch (Exception e) {
			model.setStatusEmail(StatusEmail.ERROR);
		}finally {
			return emailRepository.save(model);
		}
		
	}
	
}
