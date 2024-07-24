package com.ecommerce.platform.iam.domain.services;

import  com.ecommerce.platform.iam.domain.model.commands.SeedRolesCommand;
import org.springframework.stereotype.Service;

@Service
public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
