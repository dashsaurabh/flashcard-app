package org.domain.user.email.events.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface UserEventChannel {

    @Input("userCreateEvent")
    SubscribableChannel userCreateEventChannel();
}
