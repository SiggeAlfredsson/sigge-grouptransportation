package com.siggebig.GroupTransport.repo;

import com.siggebig.GroupTransport.model.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRegistrationRepository extends JpaRepository<UserRegistration, Long> {
}
