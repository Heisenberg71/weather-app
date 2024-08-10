package com.example.weather_app.gateway;

import com.example.weather_app.entity.WeatherEntity;

public interface WeatherGateway {

    WeatherEntity getWeather(String weather);
}
