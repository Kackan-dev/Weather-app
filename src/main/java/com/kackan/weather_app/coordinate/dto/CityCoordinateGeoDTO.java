package com.kackan.weather_app.coordinate.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CityCoordinateGeoDTO(String name, Double latitude, Double longitude, String timezone, String country) {
}
