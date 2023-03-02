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

    @PatchMapping("vehicle/use/{state}/{vehicleId}") //state 0=false 1=true
    public void setAvailableState(@PathVariable String state, @PathVariable long vehicleId) {
        Vehicle newVehicle = vehicleService.get(vehicleId);

        switch(state) {
            case "1": newVehicle.setAvailable(true); break;
            case "0": newVehicle.setAvailable(false); break;
            default: throw new IllegalStateException(state + " was illdefined");
        }

        vehicleService.save(newVehicle);

    }

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

    @PostMapping("vehicle/{vehicleId}/{groupId}")
    public ResponseEntity<String> addVehicleToGroup(@PathVariable Long vehicleId, @PathVariable Long groupId) {
        vehicleService.addVehicleToGroup(vehicleId, groupId);
        return ResponseEntity.ok("Vehicle added to group successfully.");
    }

    @DeleteMapping("vehicle/{vehicleId}/{groupId}")
    public ResponseEntity<String> removeVehicleFromGroup(@PathVariable Long vehicleId, @PathVariable Long groupId) {
        vehicleService.removeVehicleFromGroup(vehicleId, groupId);
        return ResponseEntity.ok("Vehicle removed from group successfully.");
    }

}
