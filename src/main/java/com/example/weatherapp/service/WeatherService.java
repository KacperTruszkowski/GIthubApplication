package com.example.weatherapp.service;

import com.example.weatherapp.WeatherRepository;
import com.example.weatherapp.model.Weather;
import com.example.weatherapp.model.WeatherDto;
import com.example.weatherapp.webclient.WeatherClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;
    private final WeatherClient weatherClient;

    public String saveWeather(WeatherDto weatherDto) {
        Weather weather = new Weather();
        weather.setTime(weatherDto.getTime()[0]);
        weather.setSunrise(weatherDto.getSunrise()[0]);
        weather.setSunset(weatherDto.getSunset()[0]);
//        weather.setPrecipitation_sum(weatherDto.getPrecipitation_sum()[0]);
        weatherRepository.save(weather);
        return "null";
    }

    public WeatherDto getWeather() {
        return weatherClient.getWeather(51.25, 22.52);
    }
}
