package edu.greenriver.sdev.exampleprogram.model;

public class WeatherReading
{
    private String dateTime;
    private String location;
    private String condition; //foggy, rainy, sunny, ...
    private double tempFaren;

    public WeatherReading(String dateTime, String location,
                          String condition, double tempFaren)
    {
        this.dateTime = dateTime;
        this.location = location;
        this.condition = condition;
        this.tempFaren = tempFaren;
    }

    public String getDateTime()
    {
        return dateTime;
    }

    public void setDateTime(String dateTime)
    {
        this.dateTime = dateTime;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getCondition()
    {
        return condition;
    }

    public void setCondition(String condition)
    {
        this.condition = condition;
    }

    public double getTempFaren()
    {
        return tempFaren;
    }

    public void setTempFaren(double tempFaren)
    {
        this.tempFaren = tempFaren;
    }

    @Override
    public String toString()
    {
        return "WeatherReading{" +
                "dateTime='" + dateTime + '\'' +
                ", location='" + location + '\'' +
                ", condition='" + condition + '\'' +
                ", tempFaren=" + tempFaren +
                '}';
    }
}
