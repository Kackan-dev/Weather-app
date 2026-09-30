package com.kackan.weather_app.weather.dto;

import com.kackan.weather_app.coordinate.enums.PolishProvinceCapitalsEnum;

public record PolishProvinceWeatherForecastDTO(PolishProvinceCapitalsEnum polishProvinceCapitalsEnum, WeatherForecastDTO weatherForecastDTO) {
}
