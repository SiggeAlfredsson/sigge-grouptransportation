package com.siggebig.GroupTransport.service;

import com.siggebig.GroupTransport.Exception.GroupNotFoundException;
import com.siggebig.GroupTransport.Exception.VehicleNotFoundException;
import com.siggebig.GroupTransport.model.Group;
import com.siggebig.GroupTransport.model.Vehicle.Vehicle;
import com.siggebig.GroupTransport.model.Vehicle.VehicleRegistration;
import com.siggebig.GroupTransport.repo.JpaGroupRepository;
import com.siggebig.GroupTransport.repo.JpaVehicleRegistrationRepository;
import com.siggebig.GroupTransport.repo.JpaVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private JpaVehicleRepository jpaVehicleRepository;

    @Autowired
    private JpaGroupRepository jpaGroupRepository;

    @Autowired
    JpaVehicleRegistrationRepository jpaVehicleRegistrationRepository;

    public List<Vehicle> getAll() {
        return jpaVehicleRepository.findAll();
    }

    public Vehicle save(Vehicle vehicle) {
        return jpaVehicleRepository.save(vehicle);
    }

    public void delete(long vehicleId) {
        jpaVehicleRepository.deleteById(vehicleId);
    }

    public Vehicle get(long id) {
        return jpaVehicleRepository.getReferenceById(id);
    }

    public void addVehicleToGroup(Long vehicleId, Long groupId) {
        Vehicle vehicle = jpaVehicleRepository.findById(vehicleId).orElseThrow(() -> new VehicleNotFoundException(vehicleId));
        Group group = jpaGroupRepository.findById(groupId).orElseThrow(() -> new GroupNotFoundException(groupId));

        VehicleRegistration reg = new VehicleRegistration();

        reg.setVehicle(vehicle);
        reg.setGroup(group);
        reg.setAddedToGroupAt(LocalDateTime.now());

       jpaVehicleRepository.save(vehicle);
       jpaGroupRepository.save(group);
       jpaVehicleRegistrationRepository.save(reg);

    }

}
