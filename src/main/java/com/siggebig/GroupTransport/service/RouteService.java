package com.siggebig.GroupTransport.service;

import com.siggebig.GroupTransport.Exception.GroupNotFoundException;
import com.siggebig.GroupTransport.model.Group;
import com.siggebig.GroupTransport.model.Route;
import com.siggebig.GroupTransport.model.RouteRegistration;
import com.siggebig.GroupTransport.repo.JpaGroupRepository;
import com.siggebig.GroupTransport.repo.JpaRouteRegistrationRepository;
import com.siggebig.GroupTransport.repo.JpaRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RouteService {

    @Autowired
    private JpaRouteRegistrationRepository jpaRouteRegistrationRepository;

    @Autowired
    private JpaGroupRepository jpaGroupRepository;

    @Autowired
    private JpaRouteRepository jpaRouteRepository;




    public void addCarRouteToGroup(Long groupId, String origin, String destination) {
        Group group = jpaGroupRepository.findById(groupId).orElseThrow(() -> new GroupNotFoundException(groupId));


        Route route = new Route();
        route.setOrigin(origin);
        route.setDestination(destination);

        RouteRegistration reg = new RouteRegistration();

        reg.setRoute(route);
        reg.setGroup(group);
        reg.setAddedToGroupAt(LocalDateTime.now());

        jpaRouteRepository.save(route);
        jpaGroupRepository.save(group);
        jpaRouteRegistrationRepository.save(reg);
    }

}
