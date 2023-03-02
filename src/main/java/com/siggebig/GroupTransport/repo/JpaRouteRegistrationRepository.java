package com.siggebig.GroupTransport.repo;

import com.siggebig.GroupTransport.model.RouteRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRouteRegistrationRepository extends JpaRepository<RouteRegistration,Long> {
}
