package com.siggebig.GroupTransport.model.Vehicle;

import lombok.Getter;

@Getter
public class VehicleStateDetails {
    private Vehicle oldState;
    private Vehicle newState;

    public VehicleStateDetails(Vehicle oldState, Vehicle newState) {
        this.oldState = oldState.clone();
        this.newState = newState.clone();
    }
}
