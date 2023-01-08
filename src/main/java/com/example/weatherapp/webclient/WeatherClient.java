package com.example.weatherapp.webclient;

import com.example.weatherapp.dto.OpenWeatherWeatherDto;
import com.example.weatherapp.model.WeatherDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherClient {

    private static final String WEATHER_URL = "https://api.open-meteo.com/v1/forecast?";
    private RestTemplate restTemplate = new RestTemplate();

    public WeatherDto getWeather(double lat, double lon) {
        OpenWeatherWeatherDto openWeatherWeatherDto = restTemplate.getForObject(WEATHER_URL + "latitude={lat}&longitude={lon}&daily=temperature_2m_max," +
                        "sunrise,sunset,precipitation_sum,windspeed_10m_max&timezone=Europe/London&past_days=7",
                OpenWeatherWeatherDto.class,lat, lon);
        return WeatherDto.builder()
                .time(openWeatherWeatherDto.getDaily().getTime())
                .precipitation_sum(openWeatherWeatherDto.getDaily().getPrecipitation_sum())
                .sunrise(openWeatherWeatherDto.getDaily().getSunrise())
                .sunset(openWeatherWeatherDto.getDaily().getSunset())
                .build();
        }
    }
