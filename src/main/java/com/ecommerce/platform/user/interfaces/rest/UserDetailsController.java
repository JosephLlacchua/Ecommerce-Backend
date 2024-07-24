package com.ecommerce.platform.user.interfaces.rest;


import com.ecommerce.platform.user.domain.model.aggregates.UserDetails;
import com.ecommerce.platform.user.domain.model.queries.GetAllUserDetailsQuery;
import com.ecommerce.platform.user.domain.model.queries.GetUserDetailsByIdQuery;
import com.ecommerce.platform.user.domain.services.UserDetailsCommandService;
import com.ecommerce.platform.user.domain.services.UserDetailsQueryService;
import com.ecommerce.platform.user.interfaces.rest.resources.CreateUserDetailsResource;
import com.ecommerce.platform.user.interfaces.rest.resources.UserDetailsResource;
import com.ecommerce.platform.user.interfaces.rest.transform.CreateUserDetailsCommandFromResourceAssembler;
import com.ecommerce.platform.user.interfaces.rest.transform.UserDetailsResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user-details")
public class UserDetailsController {
    private final UserDetailsCommandService userDetailsCommandService;
    private final UserDetailsQueryService userDetailsQueryService;

    public UserDetailsController(UserDetailsCommandService userDetailsCommandService, UserDetailsQueryService userDetailsQueryService) {
        this.userDetailsCommandService = userDetailsCommandService;
        this.userDetailsQueryService = userDetailsQueryService;
    }

    @PostMapping
    public ResponseEntity<UserDetailsResource> createUserDetails(@RequestBody CreateUserDetailsResource resource) {
        var createUserDetailsCommand = CreateUserDetailsCommandFromResourceAssembler.toCommandFromResource(resource);
        var userDetailsId = userDetailsCommandService.handle(createUserDetailsCommand);
        if (userDetailsId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getUserDetailsByIdQuery = new GetUserDetailsByIdQuery(userDetailsId);
        var userDetails = userDetailsQueryService.handle(getUserDetailsByIdQuery);
        if (userDetails.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var userDetailsResource = UserDetailsResourceFromEntityAssembler.toResourceFromEntity(userDetails.get());
        return new ResponseEntity<>(userDetailsResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDetailsResource>> getAllUserDetails(){
        var getAllUserDetailsQuery = new GetAllUserDetailsQuery();
        var userDetails = userDetailsQueryService.handle(getAllUserDetailsQuery);
        var userDetailsResources = userDetails.stream()
                .map(UserDetailsResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(userDetailsResources);
    }
    @GetMapping("/{userDetailsId}")
    public ResponseEntity<UserDetailsResource> getUserDetailsById(@PathVariable Long userDetailsId) {
        var getUserDetailsByIdQuery = new GetUserDetailsByIdQuery(userDetailsId);
        var userDetails = userDetailsQueryService.handle(getUserDetailsByIdQuery);
        if (userDetails.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var userDetailsResource = UserDetailsResourceFromEntityAssembler.toResourceFromEntity(userDetails.get());
        return ResponseEntity.ok(userDetailsResource);
    }


}
