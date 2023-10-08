package edu.greenriver.sdev.exampleprogram;

import edu.greenriver.sdev.exampleprogram.db.IWeatherReadingRepository;
import edu.greenriver.sdev.exampleprogram.model.WeatherReading;
import edu.greenriver.sdev.exampleprogram.services.WeatherService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class ExampleProgramApplication
{
	public static void main(String[] args)
	{
		//get access to the spring container (aka the application context)
		ApplicationContext context = SpringApplication.run(ExampleProgramApplication.class, args);

		//ask the spring container for our data layer (a spring bean)
		IWeatherReadingRepository repo = context.getBean(IWeatherReadingRepository.class);

		//records to add to our db
		List<WeatherReading> readings = List.of(
			new WeatherReading("10/10/21 9pm", "Spokane", "Clear Skies", 70.0),
			new WeatherReading("12/1/16 2pm", "Tacoma", "Snow", 24.0),
			new WeatherReading("3/3/22 4pm", "Puyallup", "Rain", 66.0),
			new WeatherReading("2/1/23 10pm", "Puyallup", "Rain", 68.0)
		);

		for (WeatherReading reading : readings)
		{
			repo.save(reading);
		}
	}
}
