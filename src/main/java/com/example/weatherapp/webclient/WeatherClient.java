package com.example.weatherapp.webclient;


import com.example.weatherapp.dto.OpenWeatherMainDto;
import com.example.weatherapp.model.WeatherDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherClient {

    private static final String WEATHER_URL = "https://api.open-meteo.com/v1/forecast?";
    private RestTemplate restTemplate = new RestTemplate();

    public WeatherDto getWeather(double lat, double lon) {
        OpenWeatherMainDto openWeatherMainDto = restTemplate.getForObject(WEATHER_URL + "latitude={lat}&longitude={lon}&daily=temperature_2m_max," +
                        "sunrise,sunset,precipitation_sum,windspeed_10m_max&timezone=Europe/London&past_days=7",
                OpenWeatherMainDto.class,lat, lon);
        return WeatherDto.builder()
                .time(openWeatherMainDto.getDaily().getTime())
                .sunrise(openWeatherMainDto.getSunrise().getSunrise())
                .sunset(openWeatherMainDto.getSunset().getSunset())
                .precipitation_sum(openWeatherMainDto.getPrecipitation_sum().getPrecipitation_sum())
                .build();
        }
    }