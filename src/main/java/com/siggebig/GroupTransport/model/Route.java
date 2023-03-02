package com.siggebig.GroupTransport.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
@Table(name="routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    private List<Step> steps;

    private String duration;
    private String durationInTraffic;
    private String arrivalTime;

    private String origin;
    private String destination;



    @OneToMany(mappedBy = "route")
    @JsonIgnoreProperties("route")
    Set<RouteRegistration> registrations;

    @Transient
    private Weather weather;
}