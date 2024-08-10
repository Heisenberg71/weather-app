package com.example.weather_app.service;

import com.example.weather_app.response.WeatherReportResponse;

import java.util.List;

public interface WeatherService {

    WeatherReportResponse loadCityWeather(String cityName);

    List<WeatherReportResponse> getAllCityWeather();

    List<WeatherReportResponse> showBetweenLongitudeRange(double minLongitude, double maxLongitude);

    List<WeatherReportResponse> showBetweenLatitudeRange(double minLatitude, double maxLatitude);

    List<WeatherReportResponse> sortByLatitude();

    List<WeatherReportResponse> sortByLongitude();

    List<WeatherReportResponse> searchByAddress(String address);
}
