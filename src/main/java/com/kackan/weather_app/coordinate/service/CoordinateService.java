package com.kackan.weather_app.coordinate.service;

import com.kackan.weather_app.coordinate.dto.CityCoordinateDTO;

public interface CoordinateService {
    CityCoordinateDTO getCoordinateForCity(String cityName);
}
