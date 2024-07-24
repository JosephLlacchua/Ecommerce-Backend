package com.ecommerce.platform.user.domain.services;

import com.ecommerce.platform.user.domain.model.aggregates.UserDetails;
import com.ecommerce.platform.user.domain.model.queries.GetAllUserDetailsQuery;
import com.ecommerce.platform.user.domain.model.queries.GetUserDetailsByIdQuery;

import java.util.List;
import java.util.Optional;


public interface UserDetailsQueryService {
    List<UserDetails> handle(GetAllUserDetailsQuery query);
    Optional<UserDetails> handle(GetUserDetailsByIdQuery query);
}
