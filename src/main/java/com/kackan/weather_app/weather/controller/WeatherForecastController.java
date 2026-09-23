package com.kackan.weather_app.weather.controller;

import com.kackan.weather_app.weather.dto.WeatherForecastDTO;
import com.kackan.weather_app.weather.service.WeatherForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/forecast")
@CrossOrigin(value = "http://localhost:4200")
public class WeatherForecastController {
    private final WeatherForecastService weatherForecastService;

    @Autowired
    public WeatherForecastController(WeatherForecastService weatherForecastService) {
        this.weatherForecastService = weatherForecastService;
    }

    @GetMapping("/{cityName}/week")
    public ResponseEntity<WeatherForecastDTO> getWeekWeatherForecast(@PathVariable String cityName) {
        return new ResponseEntity<>(weatherForecastService.getWeekWeatherForecastForCityName(cityName),
                HttpStatus.valueOf(200));
    }

    @GetMapping("/{cityName}/day")
    public ResponseEntity<WeatherForecastDTO> getTodayWeatherForecast(@PathVariable String cityName) {
        return new ResponseEntity<>(weatherForecastService.getTodayWeatherForecastForCityName(cityName),
                HttpStatus.valueOf(200));
    }
}
