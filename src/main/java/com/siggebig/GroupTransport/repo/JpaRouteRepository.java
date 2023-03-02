package com.siggebig.GroupTransport.repo;

import com.siggebig.GroupTransport.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRouteRepository extends JpaRepository<Route, Long> {
}
