package edu.greenriver.sdev.exampleprogram.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherReading
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String dateTime;
    private String location;
    private String condition; //foggy, rainy, sunny, ...
    private double tempFaren;

    public WeatherReading(String dateTime, String location, String condition, double tempFaren)
    {
        this.dateTime = dateTime;
        this.location = location;
        this.condition = condition;
        this.tempFaren = tempFaren;
    }
}
