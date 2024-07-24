package com.ecommerce.platform.iam.domain.model.commands;

import  com.ecommerce.platform.iam.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String email, String password, List<Role> roles) {
}
