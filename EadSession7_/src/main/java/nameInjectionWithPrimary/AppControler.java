package nameInjectionWithPrimary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppControler {
	@Autowired
	private MailSender mailSenderObject;

	
	@GetMapping("/sendQualifier")
	public String sendMail() {

		System.out.println("aaaaaaaaaaaaaa");
		mailSenderObject.sendmail();

		return "Mail sent successfully";
	}
}
