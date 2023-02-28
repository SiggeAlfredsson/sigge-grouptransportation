package com.siggebig.GroupTransport.repo;

import com.siggebig.GroupTransport.model.Vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaVehicleRepository extends JpaRepository<Vehicle, Long> {
}
