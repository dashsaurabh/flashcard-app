package org.domain.user.management.events.listeners;

import org.domain.user.management.events.models.User;

public interface UserEventListener {

    public void processUserRegisteredEvent(User user);
}
