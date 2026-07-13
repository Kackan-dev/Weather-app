package com.kackan.weather_app.config;

import com.kackan.weather_app.coordinate.client.CoordinateHttpClient;
import com.kackan.weather_app.weather.client.WeatherHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.support.RestClientHttpServiceGroupConfigurer;
import org.springframework.web.service.registry.ImportHttpServices;

@Configuration
@ImportHttpServices(group = "coordinate", types = {CoordinateHttpClient.class})
@ImportHttpServices(group = "weather", types = {WeatherHttpClient.class})
public class HttpClientsConfig {

    @Value("${api.url.coordinate}")
    private String coordinateApiUrl;

    @Value("${api.url.weather}")
    private String weatherApiUrl;

    public String getCoordinateApiUrl() {
        return coordinateApiUrl;
    }

    public void setCoordinateApiUrl(String coordinateApiUrl) {
        this.coordinateApiUrl = coordinateApiUrl;
    }

    public String getWeatherApiUrl() {
        return weatherApiUrl;
    }

    public void setWeatherApiUrl(String weatherApiUrl) {
        this.weatherApiUrl = weatherApiUrl;
    }

    @Bean
    RestClientHttpServiceGroupConfigurer restClientHttpServiceGroupConfigurer() {
        return groups -> {
            groups.filterByName("weather").forEachClient((group, clientBuilder) -> clientBuilder.baseUrl(weatherApiUrl));
            groups.filterByName("coordinate").forEachClient(((group, clientBuilder) -> clientBuilder.baseUrl(coordinateApiUrl)));
        };
    }
}
