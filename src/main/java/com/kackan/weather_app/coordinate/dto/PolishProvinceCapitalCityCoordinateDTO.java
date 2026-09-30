package com.kackan.weather_app.coordinate.dto;

import com.kackan.weather_app.coordinate.enums.PolishProvinceCapitalsEnum;

public record PolishProvinceCapitalCityCoordinateDTO(PolishProvinceCapitalsEnum polishProvinceCapitalsEnum, CityCoordinateDTO cityCoordinateDTO) {}

