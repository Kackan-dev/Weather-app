package com.kackan.weather_app.weather.service;

import com.kackan.weather_app.weather.dto.PolishProvinceWeatherForecastDTO;
import com.kackan.weather_app.weather.dto.WeatherForecastDTO;

import java.util.List;

public interface WeatherForecastService {
    WeatherForecastDTO getWeekWeatherForecastForCityName(String cityName);

    WeatherForecastDTO getTodayWeatherForecastForCityName(String cityName);

    List<PolishProvinceWeatherForecastDTO> getTodayWeatherForecastForPolishProvinces();
}

