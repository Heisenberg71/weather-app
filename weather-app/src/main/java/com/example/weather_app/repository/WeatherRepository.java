package com.example.weather_app.repository;

import com.example.weather_app.entity.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherEntity, Long> {

    List<WeatherEntity> findByLongitudeBetween(double minLongitude, double maxLongitude);
    List<WeatherEntity> findByLatitudeBetween(double minLatitude, double maxLatitude);
    List<WeatherEntity> findByAddress(String address);
}
