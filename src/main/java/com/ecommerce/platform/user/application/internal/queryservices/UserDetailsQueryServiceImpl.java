package com.ecommerce.platform.user.application.internal.queryservices;

import com.ecommerce.platform.user.domain.model.aggregates.UserDetails;
import com.ecommerce.platform.user.domain.model.queries.GetAllUserDetailsQuery;
import com.ecommerce.platform.user.domain.model.queries.GetUserDetailsByIdQuery;
import com.ecommerce.platform.user.domain.services.UserDetailsQueryService;
import com.ecommerce.platform.user.infrastructure.persistence.jpa.UserDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsQueryServiceImpl implements UserDetailsQueryService {

    private final UserDetailsRepository userDetailsRepository;

    public UserDetailsQueryServiceImpl(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }
    @Override
    public List<UserDetails> handle(GetAllUserDetailsQuery query) {
        return userDetailsRepository.findAll();
    }

    @Override
    public Optional<UserDetails> handle(GetUserDetailsByIdQuery query) {
        return userDetailsRepository.findById(query.userDetailsId());
    }
}
