package com.iscs.test;

import com.iscs.test.model.Team;
import com.iscs.test.model.Weather;
import com.iscs.test.service.WeatherService;
import com.iscs.test.service.impl.FootBallServiceImpl;
import com.iscs.test.service.impl.WeatherServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TestApplicationTests {

    WeatherServiceImpl weatherService = new WeatherServiceImpl();
    FootBallServiceImpl footBallService = new FootBallServiceImpl();

    @Test
    void contextLoads() {
    }

    @Test
    void testGetAllWeatherData() throws IOException {
        String[][] data = weatherService.getAllWeatherData();
        assertNotNull(data);
    }

    @Test
    void testGetSmallestRange() throws IOException {
        Weather weather = weatherService.getSmallestTemperatureRange();
        assertEquals(14, weather.getGiorno());
        assertNotNull(weather.getMax());
        assertNotNull(weather.getMin());
    }

    @Test
    void testGetAllFootBallData() throws IOException {
        String[][] data = footBallService.getAllFootBallData();
        assertNotNull(data);
    }

    @Test
    void testGetSmallestGoalRange() throws IOException {
        Team team = footBallService.getSmallestGoalDifference();
        assertEquals(20, team.getTeamId());
        assertEquals("Leicester", team.getTeamName());
        assertNotNull(team.getTeamId());
        assertNotNull(team.getTeamName());
    }

}
