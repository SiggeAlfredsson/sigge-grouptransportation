package com.siggebig.GroupTransport.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
public class Weather {

    private double temperature;

    private double windSpeed;

    private double temperatureFeelsLike;

    private String description;
}
