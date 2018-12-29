package org.domain.user.registration.services.rules;

import org.domain.user.registration.domain.commands.UserCreateDTO;

public interface UserBusinessRulesService {
    public boolean isUserNameAlreadyTaken(UserCreateDTO userCreateDTO);
}
