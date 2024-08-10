package com.example.weather_app.gateway;

import com.example.weather_app.entity.WeatherEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class WeatherGatewayImpl implements WeatherGateway {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public WeatherEntity getWeather(String cityName) {

        String url = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/"
                + cityName
                + "?key=KTYTHFTDPG4C8BEXQTEXGXGF9";

        return restTemplate.getForObject(url, WeatherEntity.class);
    }
}
