package org.domain.user.management.services.queries;

import org.domain.user.management.domain.queries.UserQueryDTO;
import org.domain.user.management.entities.UserInfo;
import org.domain.user.management.entities.UserStatus;
import org.domain.user.management.repositories.UserInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserQueryDTO getUserInfoByUserName(String userName) {
        Optional<UserInfo> fetchedUser = userInfoRepository.findByUsername(userName);

        if (fetchedUser.isPresent()){
            UserQueryDTO userQueryDTO = new UserQueryDTO();
            System.out.println(fetchedUser.get().toString());
            userQueryDTO.setId(fetchedUser.get().getId());
            userQueryDTO.setUsername(fetchedUser.get().getUsername());
            userQueryDTO.setFirstName(fetchedUser.get().getFirstName());
            userQueryDTO.setLastName(fetchedUser.get().getLastName());
            userQueryDTO.setEmail(fetchedUser.get().getEmail());
            userQueryDTO.setStatus(UserStatus.valueOf(fetchedUser.get().getStatus()));

            System.out.println(userQueryDTO.toString());
            return userQueryDTO;
        }else{
            throw new EntityNotFoundException("UserName " + userName + " not present in records");
        }
    }
}
