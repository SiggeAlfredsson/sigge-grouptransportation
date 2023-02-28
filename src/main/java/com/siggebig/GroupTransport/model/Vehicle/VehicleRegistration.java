package com.siggebig.GroupTransport.model.Vehicle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.siggebig.GroupTransport.model.Group;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class VehicleRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime addedToGroupAt;

    @ManyToOne
    @JoinColumn(name="vehicle_id")
    @JsonIgnoreProperties("registrations")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name="group_id")
    @JsonIgnoreProperties("registrations")
    private Group group;


}
