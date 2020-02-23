package com.example.bysetterConstructor;

public class SmtpMailSender implements MailSender{
	@Override
	public void sendmail() {
		System.out.println("smtp mail");
		
	}

}
