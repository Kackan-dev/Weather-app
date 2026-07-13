package com.kackan.weather_app.coordinate.client;

import com.kackan.weather_app.coordinate.response.CityCoordinateGeoResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

public interface CoordinateHttpClient {
    @GetExchange(accept = "application/json")
    CityCoordinateGeoResponse getCityCoordinates(@RequestParam("count") int count, @RequestParam("name") String name);
}
