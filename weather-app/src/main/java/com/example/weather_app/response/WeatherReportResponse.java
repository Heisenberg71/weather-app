package com.example.weather_app.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WeatherReportResponse implements Serializable {

    private long id;
    private double latitude;
    private double longitude;
    private String address;
    private String description;
}
