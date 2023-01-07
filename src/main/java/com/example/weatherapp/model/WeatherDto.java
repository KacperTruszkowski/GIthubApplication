package com.example.weatherapp.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WeatherDto {

    private String time;
    private String sunrise;
    private String sunset;
    private double precipitation_sum;
}
