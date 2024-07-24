package com.ecommerce.platform.user.application.internal.commandservices;

import com.ecommerce.platform.iam.domain.model.aggregates.User;
import com.ecommerce.platform.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import com.ecommerce.platform.user.domain.model.aggregates.UserDetails;
import com.ecommerce.platform.user.domain.model.commands.CreateUserDetailsCommand;
import com.ecommerce.platform.user.domain.services.UserDetailsCommandService;
import com.ecommerce.platform.user.infrastructure.persistence.jpa.UserDetailsRepository;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsCommadServiceImpl implements UserDetailsCommandService {
    private final UserDetailsRepository userDetailsRepository;

    private final UserRepository userRepository;


    public UserDetailsCommadServiceImpl(UserDetailsRepository userDetailsRepository,UserRepository userRepository) {
        this.userDetailsRepository = userDetailsRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Long handle(CreateUserDetailsCommand command) {
        var user = userRepository.findById(command.userId());
        if(user.isEmpty()){
            throw new IllegalArgumentException("User does not exist");
        }
        var userDetails = new UserDetails(command,user.get());
        try {
            userDetailsRepository.save(userDetails);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving user details: " + e.getMessage());
        }
        return userDetails.getId();
    }

}
