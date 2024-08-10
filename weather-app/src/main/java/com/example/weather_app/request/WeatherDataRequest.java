package com.example.weather_app.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WeatherDataRequest {
    private double latitude;
    private double longitude;
    private String address;
    private String description;

}
