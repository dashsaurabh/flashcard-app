package org.domain.user.email.services.builders;

import org.domain.user.email.domain.UserActivationEmail;
import org.domain.user.email.events.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserActivationEmailServiceImpl implements UserActivationEmailService {

    @Override
    public UserActivationEmail buildUserActivationEmail(User user) {
        System.out.println(user);
        UserActivationEmail userActivationEmail = new UserActivationEmail(user.getEmail(), getUserActivationSubject(), getActivationMessage(user));
        return userActivationEmail;

    }

    private String getUserActivationSubject(){
        return new String("Welcome to FlashCard App! Confirm your email!!");
    }

    private String getActivationMessage(User user){
        return new String("To Activate Account, click on the URL: " + getActivationUrl(user));
    }

    private String getActivationUrl(User user){
        return new String("http://localhost:8080/registration-application/user/" + user.getId() + "/registrationConfirm?token=" + user.getVerificationToken());
    }
}
