package com.example.weatherapp.dto;

import lombok.Getter;

@Getter
public class OpenWeatherDailyDto {

    private String [] time;
    private String [] sunrise;
    private String [] sunset;
    private String [] precipitation_sum;
}
