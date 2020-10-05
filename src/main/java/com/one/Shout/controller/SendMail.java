package com.one.Shout.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.one.Shout.service.SendMailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
public class SendMail {

	@Autowired
	SendMailService sendMailService;
	
	@RequestMapping(value = "/sendemail")
	public String sendEmail() throws AddressException, MessagingException, IOException {
		
		log.info("Calling Mail API to send Email");
		sendMailService.sendingMail("chakresh@acis.io", "Message From XYZ", "BODY");
		return "Email sent successfully";
	}

	
}
