package com.kackan.weather_app.weather.controller;

import com.kackan.weather_app.weather.dto.WeekWeatherForecastDTO;
import com.kackan.weather_app.weather.service.WeatherForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/forecast")
public class WeatherForecastController {
    private final WeatherForecastService weatherForecastService;

    @Autowired
    public WeatherForecastController(WeatherForecastService weatherForecastService) {
        this.weatherForecastService = weatherForecastService;
    }

    @GetMapping("/{cityName}/week")
    public ResponseEntity<WeekWeatherForecastDTO> getWeekWeatherForecast(@PathVariable String cityName) {
        return new ResponseEntity<>(weatherForecastService.getWeekWeatherForecastForCityName(cityName),
                HttpStatus.valueOf(200));
    }
}
