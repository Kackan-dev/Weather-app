package com.kackan.weather_app.coordinate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CityCoordinateDTO(@JsonProperty("latitude") double latitude, @JsonProperty("longitude") double longitude) {
}
