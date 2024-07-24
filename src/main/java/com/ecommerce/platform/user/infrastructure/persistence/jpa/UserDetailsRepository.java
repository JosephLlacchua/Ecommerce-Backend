package com.ecommerce.platform.user.infrastructure.persistence.jpa;

import com.ecommerce.platform.user.domain.model.aggregates.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
}
