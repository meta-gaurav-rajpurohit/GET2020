package qualifier;

import org.springframework.stereotype.Component;

@Component("beanMock")
public class MockMailSender implements MailSender{
	
	@Override
	public void sendmail() {
		System.out.println("mock mail");
	}
}
