package com.kackan.weather_app.weather.service;

import com.kackan.weather_app.weather.dto.WeatherForecastDTO;

public interface WeatherForecastService {
    WeatherForecastDTO getWeekWeatherForecastForCityName(String cityName);

    WeatherForecastDTO getTodayWeatherForecastForCityName(String cityName);
}

