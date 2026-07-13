package com.kackan.weather_app.weather.service;

import com.kackan.weather_app.weather.dto.WeekWeatherForecastDTO;

public interface WeatherForecastService {
    WeekWeatherForecastDTO getWeekWeatherForecastForCityName(String cityName);
}

