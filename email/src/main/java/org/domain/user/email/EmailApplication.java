package org.domain.user.email;

import com.sendgrid.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.io.IOException;

@SpringBootApplication
@EnableEurekaClient
public class EmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailApplication.class, args);

		/*Email from = new Email("test@example.com");
		String subject = "Sending with SendGrid is Fun";
		Email to = new Email("saurabh.dashora@gmail.com");
		Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
		Mail mail = new Mail(from, subject, to, content);

		SendGrid sg = new SendGrid("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");
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());
		} catch (IOException ex) {
			System.out.println(ex);
		}*/

	}

}

