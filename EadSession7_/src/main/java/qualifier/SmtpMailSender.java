package qualifier;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("beanSmtp")
public class SmtpMailSender implements MailSender{
	@Override
	public void sendmail() {
		System.out.println("smtp mail");
		
	}

}
