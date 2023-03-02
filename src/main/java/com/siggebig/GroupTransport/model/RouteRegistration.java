package com.siggebig.GroupTransport.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.sql.results.spi.LoadContexts;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class RouteRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime addedToGroupAt;

    @ManyToOne
    @JoinColumn(name = "group_id")
    @JsonIgnoreProperties("registrations")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "route_id")
    @JsonIgnoreProperties("registrations")
    private Route route;

}
