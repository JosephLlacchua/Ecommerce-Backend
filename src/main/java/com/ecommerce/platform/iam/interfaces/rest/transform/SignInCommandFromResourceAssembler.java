package com.ecommerce.platform.iam.interfaces.rest.transform;

import com.ecommerce.platform.iam.domain.model.commands.SignInCommand;
import com.ecommerce.platform.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.email(), signInResource.password());
    }
}
