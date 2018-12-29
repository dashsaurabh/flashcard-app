package org.domain.user.management.repositories;

import org.domain.user.management.entities.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {
    Optional<UserInfo> findByUsername(String userName);
}
