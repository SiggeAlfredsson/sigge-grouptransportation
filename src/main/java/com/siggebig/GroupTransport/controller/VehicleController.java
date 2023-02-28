package com.siggebig.GroupTransport.controller;

import com.siggebig.GroupTransport.model.Vehicle;
import com.siggebig.GroupTransport.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {



    @Autowired
    private VehicleService vehicleService;


    @GetMapping("vehicle")
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.getAll();

        if (vehicles.isEmpty()) {
            return ResponseEntity
                    .status(204)
                    .header("x-info", "No data found in db")
                    .build();
        } else {
            return ResponseEntity.ok(vehicles);
        }
    }

    @PostMapping("vehicle")
    public ResponseEntity<List<Vehicle>> addVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.save(vehicle);

        List<Vehicle> vehicles = vehicleService.getAll();
        return ResponseEntity.status(201).body(vehicles);
    }



    @DeleteMapping("vehicle/{vehicleId}")
    public ResponseEntity<List<Vehicle>> removeVehicle(@PathVariable long vehicleId) {

        List<Vehicle> vehicles = vehicleService.getAll();

        if (vehicleId > vehicles.size()) {
            return ResponseEntity
                    .status(400)
                    .header("x-error-msg", "Id out of bounds, no vehicle with that id")
                    .build();
        } else {

            vehicleService.delete(vehicleId);
            return getAllVehicles();
        }
    }

    @PostMapping("testvehicle/{vehicleId}/{groupId}")
    public ResponseEntity<String> addUserToGroup(@PathVariable Long vehicleId, @PathVariable Long groupId) {
        vehicleService.addVehicleToGroup(vehicleId, groupId);
        return ResponseEntity.ok("Vehicle added to group successfully.");
    }

}
