package org.domain.user.management.events.listeners;

import org.domain.user.management.controllers.UserQueryController;
import org.domain.user.management.events.channels.UserEventChannel;
import org.domain.user.management.events.models.User;
import org.domain.user.management.services.commands.UserCommandService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(UserEventChannel.class)
public class UserEventListenerImpl implements UserEventListener {

    @Autowired
    private UserCommandService userCommandService;

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(UserQueryController.class);

    @Override
    @StreamListener(target = "userRegisteredEvent")
    public void processUserRegisteredEvent(User user) {
        String userName = userCommandService.createUser(user);
        logger.info("New User Created " + userName);
    }
}
