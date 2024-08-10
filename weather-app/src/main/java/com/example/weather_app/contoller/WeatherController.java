package com.example.weather_app.contoller;

import com.example.weather_app.response.WeatherReportResponse;
import com.example.weather_app.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weather/api")
public class WeatherController {

    private final WeatherService weatherService;

    @PostMapping("/city/{cityName}")
    @Cacheable(value = "weather", key = "#cityName")
    public WeatherReportResponse loadCityWeather(@PathVariable String cityName) {

        return weatherService.loadCityWeather(cityName);
    }

    @GetMapping("/all")
    @Cacheable(value = "all weather")
    public List<WeatherReportResponse> getAllCityWeather() {

        return weatherService.getAllCityWeather();
    }

    @GetMapping("/latitude/sort/ascending")
    @Cacheable(value = "sort by latitude")
    public List<WeatherReportResponse> sortByLatitude() {

        return weatherService.sortByLatitude();
    }

    @GetMapping("/latitude-range")
    @Cacheable(value = "latitude-range", key = "#minLatitude - #maxLatitude")
    public List<WeatherReportResponse> showBetweenLatitudeRange(
            @RequestParam double minLatitude, @RequestParam double maxLatitude) {

        return weatherService.showBetweenLatitudeRange(minLatitude, maxLatitude);
    }

    @GetMapping("/longitude/sort/ascending")
    @Cacheable(value = "sort by longitude")
    public List<WeatherReportResponse> sortByLongitude() {

        return weatherService.sortByLongitude();
    }

    @GetMapping("/longitude-range")
    @Cacheable(value = "longitude-range", key = "#minLongitude - #maxLongitude")
    public List<WeatherReportResponse> showBetweenLongitudeRange(
            @RequestParam double minLongitude, @RequestParam double maxLongitude) {

        return weatherService.showBetweenLongitudeRange(minLongitude, maxLongitude);
    }

    @GetMapping("/address")
    @Cacheable(value = "address", key = "#address")
    public List<WeatherReportResponse> sortByAddress(@RequestParam String address) {

        return weatherService.searchByAddress(address);
    }
}
