package nameInjectionWithPrimary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SmtpMailSender implements MailSender{
	@Override
	public void sendmail() {
		System.out.println("smtp mail");
		
	}

}
