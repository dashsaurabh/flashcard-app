package org.domain.user.registration.services.commands;

import org.domain.user.registration.domain.commands.UserCreateDTO;
import org.domain.user.registration.entities.Role;
import org.domain.user.registration.entities.User;
import org.domain.user.registration.exceptions.UserIdNotAvailableException;
import org.domain.user.registration.repositories.UserRepository;
import org.domain.user.registration.services.rules.UserBusinessRulesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserCommandServiceImpl implements UserCommandService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserBusinessRulesService userBusinessRulesService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public String createUser(UserCreateDTO user)  {

        if (userBusinessRulesService.isUserNameAlreadyTaken(user)){
            throw new UserIdNotAvailableException("User Id " + user.getUserName() + " is already taken");
        }
        //Initializing the objects and mapping data
        User newUser = modelMapper.map(user, User.class);

        newUser.setId(UUID.randomUUID());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.grantAuthority(Role.ROLE_USER);
        if (user.getUserName().equals("admin"))
            newUser.grantAuthority(Role.ROLE_ADMIN);

        return userRepository.save(newUser.createUser()).getUsername();

    }
}
