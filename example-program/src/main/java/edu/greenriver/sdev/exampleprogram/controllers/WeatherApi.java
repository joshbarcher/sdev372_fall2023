package edu.greenriver.sdev.exampleprogram.controllers;

import edu.greenriver.sdev.exampleprogram.model.WeatherReading;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class declares any routes to HTTP
 * resources.
 *
 * @author Josh Archer
 * @version 1.0
 */
@RestController
@RequestMapping("api/v1")
public class WeatherApi
{
    /**
     * Return some weather data (not a web page).
     * This is a web-address (URL) and an HTTP verb
     * (GET, POST, PUT, DELETE)
     *
     * This endpoint is at http://localhost:8080/weather
     *
     * @return a list of weather data points
     */
    @GetMapping(path = "weather")
    public List<WeatherReading> getReadings()
    {
        return List.of(
            new WeatherReading("10/10/21 9pm", "Spokane", "Clear Skies", 70.0),
            new WeatherReading("12/1/16 2pm", "Tacoma", "Snow", 24.0),
            new WeatherReading("3/3/22 4pm", "Puyallup", "Rain", 66.0),
            new WeatherReading("2/1/23 10pm", "Puyallup", "Rain", 68.0)
        );
    }

    @GetMapping(path = "temps")
    public List<Double> getAllTemps()
    {
        return List.of(70.0, 24.0, 66.0, 68.0);
    }
}
