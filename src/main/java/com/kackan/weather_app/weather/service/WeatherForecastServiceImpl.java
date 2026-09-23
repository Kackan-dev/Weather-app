package com.kackan.weather_app.weather.service;

import com.kackan.weather_app.coordinate.dto.CityCoordinateDTO;
import com.kackan.weather_app.coordinate.service.CoordinateService;
import com.kackan.weather_app.utils.ListUtils;
import com.kackan.weather_app.weather.client.WeatherHttpClient;
import com.kackan.weather_app.weather.dto.WeatherForecastDTO;
import com.kackan.weather_app.weather.exception.WeatherForecastDoesntExist;
import com.kackan.weather_app.weather.exception.WeatherForecastInternalException;
import com.kackan.weather_app.coordinate.exception.WrongCoordinatesException;
import com.kackan.weather_app.weather.response.WeatherForecastResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class WeatherForecastServiceImpl implements WeatherForecastService {

    private final WeatherHttpClient weatherHttpClient;
    private final CoordinateService coordinateService;

    @Autowired
    public WeatherForecastServiceImpl(WeatherHttpClient weatherHttpClient, CoordinateService coordinateService) {
        this.weatherHttpClient = weatherHttpClient;
        this.coordinateService = coordinateService;
    }

    @Override
    public WeatherForecastDTO getWeekWeatherForecastForCityName(String cityName) {
        CityCoordinateDTO coordinateForCity = coordinateService.getCoordinateForCity(cityName);
        return getWeatherForecastForCityCoordinates(coordinateForCity.longitude(), coordinateForCity.latitude(), 7);
    }

    @Override
    public WeatherForecastDTO getTodayWeatherForecastForCityName(String cityName) {
        CityCoordinateDTO coordinateForCity = coordinateService.getCoordinateForCity(cityName);
        return getWeatherForecastForCityCoordinates(coordinateForCity.longitude(), coordinateForCity.latitude(), 1);
    }

    private WeatherForecastDTO getWeatherForecastForCityCoordinates(Double longitude, Double latitude, int dayNumbers) {
        if (longitude == null
                || latitude == null) {
            throw new WrongCoordinatesException("Longitude or latitude is empty!");
        }
        WeatherForecastResponse weatherForecastResponse = weatherHttpClient.getWeatherForecastResponse(latitude, longitude, null, dayNumbers);
        if (weatherForecastResponse == null
                || weatherForecastResponse.daily() == null
                || ListUtils.isEmpty(weatherForecastResponse.daily().time())
                || ListUtils.isEmpty(weatherForecastResponse.daily().temperatures())
                || weatherForecastResponse.dailyUnits() == null
                || weatherForecastResponse.dailyUnits().temperatureType() == null) {
            throw new WeatherForecastDoesntExist("Cannot fetch weather forecast!");
        }
        List<LocalDate> days = weatherForecastResponse.daily().time();
        List<Double> temperatures = weatherForecastResponse.daily().temperatures();
        if (days.size() != temperatures.size()) {
            throw new WeatherForecastInternalException("Days size isn't equal to temperatures size!");
        }
        Map<LocalDate, Double> weatherForecast = IntStream.range(0, weatherForecastResponse.daily().time().size())
                .boxed()
                .collect(Collectors
                        .toMap(k -> weatherForecastResponse.daily().time().get(k),
                                v -> weatherForecastResponse.daily().temperatures().get(v),
                                (oldVal, newVal) -> oldVal,
                                LinkedHashMap::new));
        return new WeatherForecastDTO(weatherForecast, weatherForecastResponse.dailyUnits().temperatureType());
    }
}
