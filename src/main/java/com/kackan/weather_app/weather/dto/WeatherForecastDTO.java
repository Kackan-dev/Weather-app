package com.kackan.weather_app.weather.dto;

import java.time.LocalDate;
import java.util.Map;

public record WeatherForecastDTO(
        Map<LocalDate, Double> weatherForecast,
        String temperatureType
) {
}
