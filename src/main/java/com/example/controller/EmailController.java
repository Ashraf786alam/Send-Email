package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Email;
import com.example.Model.EmailResponse;
import com.example.Service.EmailService;

@RestController
@CrossOrigin
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/sendEmail")
	public ResponseEntity<EmailResponse> welcome(@RequestBody Email email) {
		
		boolean t=this.emailService.sendEmail(email.getSubject(), email.getMessage(), email.getTo());
		if(t) {
			return ResponseEntity.status(HttpStatus.OK).body(new EmailResponse("Email Sent Successfully"));
		}
		else {
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			return ResponseEntity.ok(new EmailResponse("Email Couldn't send..Something went Wrong"));
		}
		
	}
	
	

}
