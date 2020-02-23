package nameInjectionWithPrimary;

import org.springframework.stereotype.Component;

@Component
public class MockMailSender implements MailSender{
	
	@Override
	public void sendmail() {
		System.out.println("mock mail");
		
	}
}
