package com.micresservice.users.core.queries;

import com.micresservice.users.application.dto.UserDto;
import com.micresservice.users.core.domain.service.users.UserService;
import com.micresservice.users.core.domain.shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUsersQuery {

    @Autowired
    private UserService userService;




}
