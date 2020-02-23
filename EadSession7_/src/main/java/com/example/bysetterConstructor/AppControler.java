package com.example.bysetterConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppControler {
	
	private MailSender mailSenderObject;

	@Autowired
	public AppControler(MailSender beanMock) {
		this.mailSenderObject = beanMock;
		System.out.println("cccccccccc");
	} 
	
	@GetMapping("/sendQualifier")
	public String sendMail() {

		System.out.println("aaaaaaaaaaaaaa");
		mailSenderObject.sendmail();

		return "Mail sent successfully";
	}
}
