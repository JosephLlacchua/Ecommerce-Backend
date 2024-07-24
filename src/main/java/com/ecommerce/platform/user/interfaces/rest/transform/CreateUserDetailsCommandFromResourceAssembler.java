package com.ecommerce.platform.user.interfaces.rest.transform;

import com.ecommerce.platform.user.domain.model.commands.CreateUserDetailsCommand;
import com.ecommerce.platform.user.interfaces.rest.resources.CreateUserDetailsResource;

public class CreateUserDetailsCommandFromResourceAssembler {
    public static CreateUserDetailsCommand toCommandFromResource(CreateUserDetailsResource resource) {
        return new CreateUserDetailsCommand(resource.fullname(), resource.direccion(), resource.telefono(), resource.userId());
    }
}
