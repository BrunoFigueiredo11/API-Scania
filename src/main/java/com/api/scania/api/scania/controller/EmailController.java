package com.api.scania.api.scania.controller;


import com.api.scania.api.scania.dto.EmailDto;
import com.api.scania.api.scania.service.EmailService;
import com.api.scania.api.scania.model.EmailModel;
import com.api.scania.api.scania.repository.EmailRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private ModelMapper modelMapper;

	
	public ResponseEntity<EmailModel> sendEmail(EmailDto model){
		EmailModel email = modelMapper.map(model, EmailModel.class);
		emailService.sendEmail(email);
		return new ResponseEntity<EmailModel>(email, HttpStatus.OK);
	}
}
