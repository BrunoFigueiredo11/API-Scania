package com.api.scania.api.scania.dto;

import com.api.scania.api.scania.model.StatusEmail;
import lombok.Data;

@Data
public class EmailDto {

	private String emailFrom;
	private String emailTo;
	private String subject;
	private String text;
	private String sendDateEmail;
	private StatusEmail statusEmail;

	public EmailDto(String emailFrom, String emailTo, String subject, String text, String sendDateEmail, StatusEmail statusEmail) {
		this.emailFrom = emailFrom;
		this.emailTo = emailTo;
		this.subject = subject;
		this.text = text;
		this.sendDateEmail = sendDateEmail;
		this.statusEmail = statusEmail;
	}

	public EmailDto() {

	}
}
