package com.kackan.weather_app.coordinate.exception;

public class WrongCoordinatesException extends RuntimeException {
    public WrongCoordinatesException(String message) {
        super(message);
    }
}
