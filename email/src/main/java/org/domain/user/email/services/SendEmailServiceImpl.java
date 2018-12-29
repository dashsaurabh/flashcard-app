package org.domain.user.email.services;

import com.sendgrid.*;
import org.domain.user.email.domain.UserActivationEmail;
import org.domain.user.email.events.models.User;
import org.domain.user.email.services.builders.UserActivationEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SendEmailServiceImpl implements SendEmailService {

    @Autowired
    private SendGrid sendGrid;

    @Autowired
    private UserActivationEmailService userActivationEmailService;

    @Override
    public void sendUserActivationEmail(User user) {

        try{
            Request request = prepareSendGridRequest(userActivationEmailService.buildUserActivationEmail(user));
            Response response = sendGrid.api(request);
        }catch(IOException e){
            System.out.println(e);
        }

    }

    private Request prepareSendGridRequest(UserActivationEmail userActivationEmail) throws IOException{
        Email from = new Email("flashcard-app@gmail.com");
        Email to = new Email(userActivationEmail.getReceiver());

        Content content = new Content("text/plain", userActivationEmail.getActivationMessage());

        Mail mail = new Mail(from, userActivationEmail.getSubject(), to, content);

        Request request = new Request();

        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());

        return request;
    }
}
