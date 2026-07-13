package com.kackan.weather_app.weather.exception;

public class WeatherForecastDoesntExist extends RuntimeException {
    public WeatherForecastDoesntExist(String message) {
        super(message);
    }
}
