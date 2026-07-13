package com.kackan.weather_app.weather.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public record Daily(
        @JsonFormat(pattern = "yyyy-MM-dd")
        List<LocalDate> time,
        @JsonProperty("temperature_2m_mean")
        List<Double>temperatures) {
}
