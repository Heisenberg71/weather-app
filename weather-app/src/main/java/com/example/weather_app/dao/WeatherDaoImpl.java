package com.example.weather_app.dao;

import com.example.weather_app.entity.WeatherEntity;
import com.example.weather_app.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class WeatherDaoImpl implements WeatherDao {

    private final WeatherRepository weatherRepository;

    @Override
    public WeatherEntity save(WeatherEntity weatherEntity) {
        return weatherRepository.save(weatherEntity);
    }

    @Override
    public List<WeatherEntity> findAllWeatherReport() {
        return weatherRepository.findAll();
    }

    @Override
    public List<WeatherEntity> findLongitudeBetween(double minLongitude, double maxLongitude) {
        return weatherRepository.findByLongitudeBetween(minLongitude, maxLongitude);
    }

    @Override
    public List<WeatherEntity> findLatitudeBetween(double minLatitude, double maxLatitude) {
        return weatherRepository.findByLatitudeBetween(minLatitude, maxLatitude);
    }

    @Override
    public List<WeatherEntity> sortByLongitude() {
        return weatherRepository.findAll(Sort.by(Sort.Direction.ASC, "longitude"));
    }

    @Override
    public List<WeatherEntity> sortByLatitude() {
        return weatherRepository.findAll(Sort.by(Sort.Direction.ASC, "latitude"));
    }

    @Override
    public List<WeatherEntity> searchByAddress(String address) {
        return weatherRepository.findByAddress(address);
    }
}
