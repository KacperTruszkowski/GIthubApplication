package com.example.weatherapp.controller;

import com.example.weatherapp.model.WeatherDto;
import com.example.weatherapp.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/weather")
    public WeatherDto getWeather() {
        return weatherService.getWeather();
    }

    @PostMapping("/weather/add")
    public String addWeather(@ModelAttribute WeatherDto weatherDto) {
        return weatherService.saveWeather(weatherDto);
    }
}
