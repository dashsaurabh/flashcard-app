package org.domain.user.email.events.listeners;

import org.domain.user.email.events.channels.UserEventChannel;
import org.domain.user.email.events.models.User;
import org.domain.user.email.services.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(UserEventChannel.class)
public class UserEventListenerImpl implements UserEventListener {

    @Autowired
    private SendEmailService sendEmailService;

    @Override
    @StreamListener(target = "userCreateEvent")
    public void processUserCreatedEvent(User user) {
        sendEmailService.sendUserActivationEmail(user);
    }
}
