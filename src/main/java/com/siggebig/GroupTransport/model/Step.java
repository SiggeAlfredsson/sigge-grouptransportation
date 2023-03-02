package com.siggebig.GroupTransport.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Embeddable
public class Step {

    private String distance;
    private String instructions;

    public Step() {}

    public Step(String distance, String instructions) {
        this.distance = distance;
        this.instructions = instructions;
    }
}