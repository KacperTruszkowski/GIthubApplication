package com.example.weatherapp.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class WeatherDto {

    private String [] time;
    private String [] sunrise;
    private String [] sunset;
    private String [] precipitation_sum;
}
