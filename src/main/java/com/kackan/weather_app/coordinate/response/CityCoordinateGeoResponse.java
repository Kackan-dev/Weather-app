package com.kackan.weather_app.coordinate.response;

import com.kackan.weather_app.coordinate.dto.CityCoordinateGeoDTO;

import java.util.List;

public record CityCoordinateGeoResponse(List<CityCoordinateGeoDTO> results){}
