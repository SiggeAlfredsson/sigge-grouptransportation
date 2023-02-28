package com.siggebig.GroupTransport.repo;

import com.siggebig.GroupTransport.model.Vehicle.VehicleRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaVehicleRegistrationRepository extends JpaRepository<VehicleRegistration, Long> {
}
