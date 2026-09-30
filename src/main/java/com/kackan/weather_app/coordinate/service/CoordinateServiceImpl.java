package com.kackan.weather_app.coordinate.service;

import com.kackan.weather_app.coordinate.client.CoordinateHttpClient;
import com.kackan.weather_app.coordinate.dto.CityCoordinateDTO;
import com.kackan.weather_app.coordinate.dto.PolishProvinceCapitalCityCoordinateDTO;
import com.kackan.weather_app.coordinate.enums.PolishProvinceCapitalsEnum;
import com.kackan.weather_app.coordinate.exception.CityDoesntExistException;
import com.kackan.weather_app.coordinate.dto.CityCoordinateGeoDTO;
import com.kackan.weather_app.coordinate.response.CityCoordinateGeoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

    @Override
    public List<PolishProvinceCapitalCityCoordinateDTO> getCoordinatesOfPolishProvinceCapitals() {
        List<Future<PolishProvinceCapitalCityCoordinateDTO>> futures;
        List<Callable<PolishProvinceCapitalCityCoordinateDTO>> list = Arrays.stream(PolishProvinceCapitalsEnum.values())
                .map(province -> (Callable<PolishProvinceCapitalCityCoordinateDTO>) () -> {
                    CityCoordinateDTO result = getCoordinateForCity(province.getCapitalCity());
                    return new PolishProvinceCapitalCityCoordinateDTO(province, result);
                })
                .toList();
        try (var executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            futures = executorService.invokeAll(list);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<PolishProvinceCapitalCityCoordinateDTO> resultList = new ArrayList<>();
        for (Future<PolishProvinceCapitalCityCoordinateDTO> provinceFuture: futures) {
            try {
                if (provinceFuture.state() == Future.State.SUCCESS) {
                    resultList.add(provinceFuture.get());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        return resultList;
    }
}
