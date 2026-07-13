package com.kackan.weather_app.coordinate.exception;

public class CityDoesntExistException extends RuntimeException {
    public CityDoesntExistException(String message) {
        super(message);
    }
}
