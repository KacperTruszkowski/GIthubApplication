package com.example.weatherapp.dto;

import lombok.Getter;

@Getter
public class OpenWeatherMainDto {

    private OpenWeatherDailyDto daily;
    private OpenWeatherSunriseDto sunrise;
    private OpenWeatherSunsetDto sunset;
    private OpenWeatherSumDto precipitation_sum;
}
