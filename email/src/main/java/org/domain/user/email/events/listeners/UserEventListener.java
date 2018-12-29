package org.domain.user.email.events.listeners;

import org.domain.user.email.events.models.User;

public interface UserEventListener {
    public void processUserCreatedEvent(User user);
}
