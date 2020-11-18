package com.iscs.test.controller;

import com.iscs.test.model.Weather;
import com.iscs.test.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by Fassil on 17/11/20.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class WeatherController {
    final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping(value = "/v1/weather/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllWeatherData() throws IOException {
        String[][] weatherData = weatherService.getAllWeatherData();
        return ResponseEntity.ok().body(weatherData);
    }

    @GetMapping(value = "/v1/weather", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSmallestRange() throws IOException {
        Weather range = weatherService.getSmallestTemperatureRange();
        return ResponseEntity.ok().body(range);
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
        return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
