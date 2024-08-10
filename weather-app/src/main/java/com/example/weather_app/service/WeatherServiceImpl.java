package com.example.weather_app.service;

import com.example.weather_app.dao.WeatherDao;
import com.example.weather_app.entity.WeatherEntity;
import com.example.weather_app.gateway.WeatherGateway;
import com.example.weather_app.response.WeatherReportResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final WeatherGateway weatherGateway;
    private final WeatherDao weatherDao;

    @Override
    public WeatherReportResponse loadCityWeather(String cityName) {

        WeatherEntity weatherEntity = weatherGateway.getWeather(cityName);
        weatherDao.save(weatherEntity);

        return WeatherReportResponse.builder()
                .id(weatherEntity.getId())
                .latitude(weatherEntity.getLatitude())
                .longitude(weatherEntity.getLongitude())
                .description(weatherEntity.getDescription())
                .address(weatherEntity.getAddress())
                .build();
    }

    @Override
    public List<WeatherReportResponse> getAllCityWeather() {
        List<WeatherEntity> allWeatherReport = weatherDao.findAllWeatherReport();

        List<WeatherReportResponse> allWeatherReportResponse = new ArrayList<>();
        for (WeatherEntity weatherEntity : allWeatherReport) {

            allWeatherReportResponse.add(
                    WeatherReportResponse.builder()
                    .id(weatherEntity.getId())
                    .latitude(weatherEntity.getLatitude())
                    .longitude(weatherEntity.getLongitude())
                    .address(weatherEntity.getAddress())
                    .description(weatherEntity.getDescription()).build()
            );
        }

        return allWeatherReportResponse;
    }

    @Override
    public List<WeatherReportResponse> showBetweenLongitudeRange(double minLongitude, double maxLongitude) {
        List<WeatherEntity> weatherReport = weatherDao.findLongitudeBetween(minLongitude, maxLongitude);

        List<WeatherReportResponse> allWeatherReportResponse = new ArrayList<>();
        for (WeatherEntity weatherEntity : weatherReport) {

            allWeatherReportResponse.add(
                    WeatherReportResponse.builder()
                            .id(weatherEntity.getId())
                            .latitude(weatherEntity.getLatitude())
                            .longitude(weatherEntity.getLongitude())
                            .address(weatherEntity.getAddress())
                            .description(weatherEntity.getDescription()).build()
            );
        }

        return allWeatherReportResponse;
    }

    @Override
    public List<WeatherReportResponse> showBetweenLatitudeRange(double minLatitude, double maxLatitude) {
        List<WeatherEntity> weatherReport = weatherDao.findLatitudeBetween(minLatitude, maxLatitude);

        List<WeatherReportResponse> allWeatherReportResponse = new ArrayList<>();
        for (WeatherEntity weatherEntity : weatherReport) {

            allWeatherReportResponse.add(
                    WeatherReportResponse.builder()
                            .id(weatherEntity.getId())
                            .latitude(weatherEntity.getLatitude())
                            .longitude(weatherEntity.getLongitude())
                            .address(weatherEntity.getAddress())
                            .description(weatherEntity.getDescription()).build()
            );
        }

        return allWeatherReportResponse;
    }

    @Override
    public List<WeatherReportResponse> sortByLatitude() {
        List<WeatherEntity> weatherReport = weatherDao.sortByLatitude();

        List<WeatherReportResponse> allWeatherReportResponse = new ArrayList<>();
        for (WeatherEntity weatherEntity : weatherReport) {

            allWeatherReportResponse.add(
                    WeatherReportResponse.builder()
                            .id(weatherEntity.getId())
                            .latitude(weatherEntity.getLatitude())
                            .longitude(weatherEntity.getLongitude())
                            .address(weatherEntity.getAddress())
                            .description(weatherEntity.getDescription()).build()
            );
        }

        return allWeatherReportResponse;
    }

    @Override
    public List<WeatherReportResponse> sortByLongitude() {
        List<WeatherEntity> weatherReport = weatherDao.sortByLongitude();

        List<WeatherReportResponse> allWeatherReportResponse = new ArrayList<>();
        for (WeatherEntity weatherEntity : weatherReport) {

            allWeatherReportResponse.add(
                    WeatherReportResponse.builder()
                            .id(weatherEntity.getId())
                            .latitude(weatherEntity.getLatitude())
                            .longitude(weatherEntity.getLongitude())
                            .address(weatherEntity.getAddress())
                            .description(weatherEntity.getDescription()).build()
            );
        }

        return allWeatherReportResponse;
    }

    @Override
    public List<WeatherReportResponse> searchByAddress(String address) {
        List<WeatherEntity> weatherReport = weatherDao.searchByAddress(address);

        List<WeatherReportResponse> allWeatherReportResponse = new ArrayList<>();
        for (WeatherEntity weatherEntity : weatherReport) {

            allWeatherReportResponse.add(
                    WeatherReportResponse.builder()
                            .id(weatherEntity.getId())
                            .latitude(weatherEntity.getLatitude())
                            .longitude(weatherEntity.getLongitude())
                            .address(weatherEntity.getAddress())
                            .description(weatherEntity.getDescription()).build()
            );
        }

        return allWeatherReportResponse;
    }
}
