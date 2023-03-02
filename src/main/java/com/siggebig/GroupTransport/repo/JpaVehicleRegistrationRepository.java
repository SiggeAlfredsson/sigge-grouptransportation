package com.siggebig.GroupTransport.repo;

import com.siggebig.GroupTransport.model.UserRegistration;
import com.siggebig.GroupTransport.model.VehicleRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaVehicleRegistrationRepository extends JpaRepository<VehicleRegistration, Long> {
    Optional<VehicleRegistration> findByVehicleIdAndGroupId(Long vehicleId, Long groupId);
}
