package com.example.weatherapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "weather")
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String time;
    private String sunrise;
    private String sunset;
    private Double precipitation_sum;
}