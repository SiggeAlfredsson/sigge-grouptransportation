package com.siggebig.GroupTransport.repo;

import com.siggebig.GroupTransport.model.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaUserRegistrationRepository extends JpaRepository<UserRegistration, Long> {
    Optional<UserRegistration> findByUserIdAndGroupId(Long userId, Long groupId);
}
