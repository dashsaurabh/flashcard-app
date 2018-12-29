package org.domain.user.registration.events.snapshots;

import java.util.UUID;

public class UserEventSnapshot {

    private final UUID id;

    private final String username;


    public UserEventSnapshot(UUID id, String username) {
        this.id = id;
        this.username = username;

    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "UserEventSnapshot{" +
                "id=" + id +
                ", userName='" + username + '\'' +
                '}';
    }
}
