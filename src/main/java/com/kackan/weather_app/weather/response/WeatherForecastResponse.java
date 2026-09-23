package com.kackan.weather_app.weather.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kackan.weather_app.weather.dto.Daily;
import com.kackan.weather_app.weather.dto.DailyUnits;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WeatherForecastResponse(
    Daily daily,
    @JsonProperty("daily_units")
    DailyUnits dailyUnits
){}
