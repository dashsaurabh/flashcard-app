package org.domain.user.management.services.queries;

import org.domain.user.management.domain.queries.UserQueryDTO;

public interface UserQueryService {

    public UserQueryDTO getUserInfoByUserName(String userName);

}
