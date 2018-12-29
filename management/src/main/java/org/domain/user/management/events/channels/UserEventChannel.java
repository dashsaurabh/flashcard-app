package org.domain.user.management.events.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface UserEventChannel {

    @Input("userRegisteredEvent")
    SubscribableChannel userCreateEventChannel();
}
