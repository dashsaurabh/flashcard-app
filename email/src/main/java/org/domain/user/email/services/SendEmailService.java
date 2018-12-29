package org.domain.user.email.services;

import org.domain.user.email.events.models.User;

public interface SendEmailService {

    public void sendUserActivationEmail(User user);
}
