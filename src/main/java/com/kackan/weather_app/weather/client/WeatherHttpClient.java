package com.kackan.weather_app.weather.client;

import com.kackan.weather_app.weather.response.WeatherForecastResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

public interface WeatherHttpClient {
    @GetExchange(accept = "application/json")
    public WeatherForecastResponse getWeatherForecastResponse(@RequestParam double latitude,
                                                              @RequestParam double longitude,
                                                              @RequestParam(name="daily",
                                                                               defaultValue = "temperature_2m_mean") String daily,
                                                              @RequestParam(name = "forecast_days") int forecastDays);
}
