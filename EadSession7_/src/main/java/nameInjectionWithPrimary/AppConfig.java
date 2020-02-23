package nameInjectionWithPrimary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.bysetterConstructor.MailSender;
import com.example.bysetterConstructor.MockMailSender;
import com.example.bysetterConstructor.SmtpMailSender;

@Configuration
public class AppConfig {
	
	@Bean("beanMock")
	public MailSender getMockMailSender() {
		return new MockMailSender();
	}
	/*
	 * method will return smtpMailSender object.
	 */

	@Bean("beanSmtp")
	public MailSender getSmtpMailSender() {
		System.out.println("bbbbbbbbaaa");
		return new SmtpMailSender();
	}

}
