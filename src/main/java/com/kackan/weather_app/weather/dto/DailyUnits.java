package com.kackan.weather_app.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DailyUnits(
        @JsonProperty("temperature_2m_mean")
        String temperatureType) {
}
