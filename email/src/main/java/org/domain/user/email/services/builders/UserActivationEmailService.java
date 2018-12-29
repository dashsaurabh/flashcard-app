package org.domain.user.email.services.builders;

import org.domain.user.email.domain.UserActivationEmail;
import org.domain.user.email.events.models.User;

public interface UserActivationEmailService {
    public UserActivationEmail buildUserActivationEmail(User user);
}
