package com.api.scania.api.scania.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "email-scania")
public class EmailModel {
	
	@Id
	private String id;

	private String emailFrom;
	private String emailTo;
	private String subject;
	private String text;
	private String sendDateEmail;
	private StatusEmail statusEmail;
}
