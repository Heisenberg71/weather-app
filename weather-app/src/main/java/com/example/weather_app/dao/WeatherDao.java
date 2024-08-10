package com.example.weather_app.dao;

import com.example.weather_app.entity.WeatherEntity;

import java.util.List;


public interface WeatherDao {
    WeatherEntity save(WeatherEntity weatherEntity);

    List<WeatherEntity> findAllWeatherReport();

    List<WeatherEntity> findLongitudeBetween(double minLongitude, double maxLongitude);

    List<WeatherEntity> findLatitudeBetween(double minLatitude, double maxLatitude);

    List<WeatherEntity> sortByLongitude();

    List<WeatherEntity> sortByLatitude();

    List<WeatherEntity> searchByAddress(String address);
}
