package edu.greenriver.sdev.exampleprogram.controllers;

import edu.greenriver.sdev.exampleprogram.model.WeatherReading;
import edu.greenriver.sdev.exampleprogram.services.WeatherService;
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
    //this field is assigned using dependency injection
    private WeatherService service;

    public WeatherApi(WeatherService service)
    {
        this.service = service;
    }

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
        return service.getAllReadings();
    }

    @GetMapping(path = "temps")
    public List<Double> getAllTemps()
    {
        return service.getAllTemps();
    }
}
