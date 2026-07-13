package com.kackan.weather_app.coordinate.service;

import com.kackan.weather_app.coordinate.client.CoordinateHttpClient;
import com.kackan.weather_app.coordinate.dto.CityCoordinateDTO;
import com.kackan.weather_app.coordinate.exception.CityDoesntExistException;
import com.kackan.weather_app.coordinate.dto.CityCoordinateGeoDTO;
import com.kackan.weather_app.coordinate.response.CityCoordinateGeoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordinateServiceImpl implements CoordinateService {

    private final CoordinateHttpClient coordinateHttpClient;

    @Autowired
    public CoordinateServiceImpl(CoordinateHttpClient coordinateHttpClient) {
        this.coordinateHttpClient = coordinateHttpClient;
    }

    @Override
    public CityCoordinateDTO getCoordinateForCity(String cityName) {
        CityCoordinateGeoResponse cityCoordinatesResponse = coordinateHttpClient.getCityCoordinates(1, cityName);
        if (cityCoordinatesResponse == null ||
        cityCoordinatesResponse.results() == null ||
        cityCoordinatesResponse.results().size() == 0) {
            throw new CityDoesntExistException("City doesn't exist, check city name!");
        }
        CityCoordinateGeoDTO cityCoordinates = cityCoordinatesResponse
                .results()
                .getFirst();
        return new CityCoordinateDTO(cityCoordinates.latitude(), cityCoordinates.longitude());
    }
}
