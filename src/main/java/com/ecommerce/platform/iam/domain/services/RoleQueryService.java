package com.ecommerce.platform.iam.domain.services;

import  com.ecommerce.platform.iam.domain.model.entities.Role;
import  com.ecommerce.platform.iam.domain.model.queries.GetAllRolesQuery;
import  com.ecommerce.platform.iam.domain.model.queries.GetRoleByNameQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RoleQueryService {
    List<Role> handle(GetAllRolesQuery query);
    Optional<Role> handle(GetRoleByNameQuery query);
}
