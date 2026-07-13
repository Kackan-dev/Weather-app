package com.kackan.weather_app.exception;

import com.kackan.weather_app.coordinate.exception.CityDoesntExistException;
import com.kackan.weather_app.weather.exception.WeatherForecastDoesntExist;
import com.kackan.weather_app.weather.exception.WeatherForecastInternalException;
import com.kackan.weather_app.coordinate.exception.WrongCoordinatesException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CityDoesntExistException.class)
    public ResponseEntity<String> handleException(CityDoesntExistException cityDoesntExistException) {
        return new ResponseEntity<>(cityDoesntExistException.getMessage(), HttpStatusCode.valueOf(404));
    }

    @ExceptionHandler(WeatherForecastDoesntExist.class)
    public ResponseEntity<String> handleException(WeatherForecastDoesntExist weatherForecastDoesntExist) {
        return new ResponseEntity<>(weatherForecastDoesntExist.getMessage(), HttpStatusCode.valueOf(404));
    }

    @ExceptionHandler(WrongCoordinatesException.class)
    public ResponseEntity<String> handleException(WrongCoordinatesException wrongCoordinatesException) {
        return new ResponseEntity<>(wrongCoordinatesException.getMessage(), HttpStatusCode.valueOf(400));
    }

    @ExceptionHandler(WeatherForecastInternalException.class)
    public ResponseEntity<String> handleException(WeatherForecastInternalException weatherForecastInternalException) {
        return new ResponseEntity<>(weatherForecastInternalException.getMessage(), HttpStatusCode.valueOf(500));
    }
}
