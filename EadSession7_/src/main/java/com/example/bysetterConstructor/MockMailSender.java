package com.example.bysetterConstructor;

public class MockMailSender implements MailSender{
	
	@Override
	public void sendmail() {
		System.out.println("mock mail");
		
	}
}
