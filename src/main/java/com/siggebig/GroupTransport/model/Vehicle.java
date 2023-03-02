package com.siggebig.GroupTransport.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "vehicles")
@NoArgsConstructor
public class Vehicle implements Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String vehicleType;

    @Column
    private boolean available = true;

    @Column
    private String location;

    @OneToMany(mappedBy = "vehicle")
    @JsonIgnoreProperties("vehicle")
    Set<VehicleRegistration> registrations;

    @Override
    public Vehicle clone() {
        try {
            return (Vehicle) super.clone();
        } catch (CloneNotSupportedException e) {
            Vehicle vehicle = new Vehicle();

            vehicle.setId(this.getId());
            vehicle.setVehicleType(this.getVehicleType());
            vehicle.setAvailable(this.isAvailable());
            vehicle.setRegistrations(registrations);

            return vehicle;
        }
    }

}
