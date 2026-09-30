package com.kackan.weather_app.coordinate.service;

import com.kackan.weather_app.coordinate.dto.CityCoordinateDTO;
import com.kackan.weather_app.coordinate.dto.PolishProvinceCapitalCityCoordinateDTO;

import java.util.List;

public interface CoordinateService {
    CityCoordinateDTO getCoordinateForCity(String cityName);

    List<PolishProvinceCapitalCityCoordinateDTO> getCoordinatesOfPolishProvinceCapitals();
}
