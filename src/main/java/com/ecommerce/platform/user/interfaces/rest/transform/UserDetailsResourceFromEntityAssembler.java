package com.ecommerce.platform.user.interfaces.rest.transform;

import com.ecommerce.platform.user.domain.model.aggregates.UserDetails;
import com.ecommerce.platform.user.interfaces.rest.resources.UserDetailsResource;

public class UserDetailsResourceFromEntityAssembler {
    public static UserDetailsResource toResourceFromEntity(UserDetails entity) {
        return new UserDetailsResource(
                entity.getId(),
                entity.getFullname(),
                entity.getDireccion(),
                entity.getTelefono(),
                entity.getUser().getId()
        );
    }
}
