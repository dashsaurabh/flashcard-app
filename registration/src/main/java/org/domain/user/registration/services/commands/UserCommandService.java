package org.domain.user.registration.services.commands;

import org.domain.user.registration.domain.commands.UserCreateDTO;

public interface UserCommandService {
    String createUser(UserCreateDTO newUser);
}
