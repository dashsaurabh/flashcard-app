package org.domain.user.email.events;

import org.domain.user.email.events.models.User;

public class UserCreatedEvent {

    private final User user;

    public UserCreatedEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
