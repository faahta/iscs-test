package com.iscs.test.service.impl;

import com.iscs.test.model.Weather;
import com.iscs.test.service.WeatherService;
import com.iscs.test.util.ReadBinaryFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fassil on 17/11/20.
 */
@Service
public class WeatherServiceImpl implements WeatherService {
    private static final Logger logger = LogManager.getLogger(WeatherServiceImpl.class);
    private static final String FILE_NAME = "weather.dat";
    @Override
    public Weather getSmallestTemperatureRange() throws IOException {
        Integer minRange=900;

        Weather weather = null;
        Path path = FileSystems.getDefault().getPath(FILE_NAME);
        /*legge il file usando la funzione di utilita 'ReadBinaryFile'*/
        String[][] weatherData = ReadBinaryFile.read(path);
        for (int i = 0; i < weatherData.length; i++) {
            for (int j = 0; j < weatherData[i].length; j++) {
                System.out.print(weatherData[i][j] + " ");
                if(j==1){
                    /*calcolare la differenza tra le colonne 1 e 2 (Massimo e Minimo rispettivamente)*/
                    Integer diff = Integer.parseInt(weatherData[i][j].substring(0,2)) - Integer.parseInt(weatherData[i][j+1].substring(0,2));
                    if(minRange > diff) {
                        /*il minimo attuale è trovato, costruire l'oggeto weather*/
                        minRange=diff;
                        weather = new Weather(weatherData[i][0], weatherData[i][1], weatherData[i][2]);
                    }
                }
            }
            System.out.println();
        }
       // logger.info(weather.toString());
        return weather;
    }

    @Override
    public String[][] getAllWeatherData() throws IOException {
        Path path = FileSystems.getDefault().getPath(FILE_NAME);
        return ReadBinaryFile.read(path);
    }
}
