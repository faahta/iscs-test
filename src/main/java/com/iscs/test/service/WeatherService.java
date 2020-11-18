package com.iscs.test.service;

import com.iscs.test.model.Weather;

import java.io.IOException;

/**
 * Created by Fassil on 17/11/20.
 */

public interface WeatherService {
    Weather getSmallestTemperatureRange() throws IOException;

    String[][] getAllWeatherData() throws IOException;
}
