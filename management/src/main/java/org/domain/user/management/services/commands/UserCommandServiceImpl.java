package org.domain.user.management.services.commands;

import org.domain.user.management.domain.commands.UserUpdateDTO;
import org.domain.user.management.entities.UserInfo;
import org.domain.user.management.entities.UserStatus;
import org.domain.user.management.entities.UserVerification;
import org.domain.user.management.events.models.User;
import org.domain.user.management.repositories.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserCommandServiceImpl implements UserCommandService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public String createUser(User user) {
        UserInfo newUser = new UserInfo();

        newUser.setId(user.getId());
        newUser.setUsername(user.getUsername());
        newUser.setStatus(String.valueOf(UserStatus.REGISTERED));
        newUser.setVerification(new UserVerification(UUID.randomUUID(), UUID.randomUUID().toString(), newUser));

        return userInfoRepository.save(newUser).getUsername();
    }

    @Override
    public String updateUser(String userName, UserUpdateDTO userUpdateDTO) {

        Optional<UserInfo> user = userInfoRepository.findByUsername(userName);

        if(user.isPresent()){
            user.get().setFirstName(userUpdateDTO.getFirstName());
            user.get().setLastName(userUpdateDTO.getLastName());
            user.get().setEmail(userUpdateDTO.getEmail());

            return userInfoRepository.save(user.get()).getUsername();
        }else{
            throw new EntityNotFoundException("UserName " + userName + " not present in records");
        }

    }

    @Override
    public String deleteUser(String userName) {
        Optional<UserInfo> user = userInfoRepository.findByUsername(userName);

        if(user.isPresent()){
            userInfoRepository.delete(user.get());
            return userName;
        }else{
            throw new EntityNotFoundException("UserName " + userName + " not present in records");
        }
    }
}
