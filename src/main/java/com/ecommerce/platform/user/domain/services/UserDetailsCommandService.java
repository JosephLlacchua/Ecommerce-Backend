package com.ecommerce.platform.user.domain.services;

import com.ecommerce.platform.user.domain.model.commands.CreateUserDetailsCommand;


public interface UserDetailsCommandService {
    Long handle(CreateUserDetailsCommand command);
}
