package com.siggebig.GroupTransport.controller;

import com.siggebig.GroupTransport.model.Group;
import com.siggebig.GroupTransport.model.Route;

import com.siggebig.GroupTransport.service.GroupService;
import com.siggebig.GroupTransport.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("route/*")
public class RouteController {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RouteService routeService;

    @GetMapping("car")
    public List<Route> getCarRoute(@RequestParam String origin, @RequestParam String destination) {
        String url = "https://grouptransport-individual.azuremicroservices.io/driving?origin={origin}&destination={destination}";
        ResponseEntity<List<Route>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Route>>() {}, origin, destination);

        System.out.println();
        return response.getBody();
    }


    @PostMapping("car/{groupId}")
    public ResponseEntity<String> addCarRouteToGroup(@PathVariable Long groupId, @RequestParam String origin, @RequestParam String destination) {

        // get vehicles in group from groupid,
        // set vehicle.isAvailable=false,
        // get route duration
        // set vehicle.setAvailableAt(LocalDateTime.now().plusMinutes(duration));
        // vehicle.setLocation(destination); ?

        routeService.addCarRouteToGroup(groupId, origin, destination);

        return ResponseEntity.ok().body("Route added to group");
    }

}
