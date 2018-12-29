package org.domain.user.management.services.commands;

import org.domain.user.management.domain.commands.UserUpdateDTO;
import org.domain.user.management.events.models.User;

public interface UserCommandService {

    public String createUser(User user);
    public String updateUser(String userName, UserUpdateDTO userUpdateDTO);
    public String deleteUser(String userName);
}
