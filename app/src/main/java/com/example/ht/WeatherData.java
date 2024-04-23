package com.example.ht;

public class WeatherData {
    private static String name;
    private static String main;
    private static String description;
    private static String temperature;
    private static String windSpeed;

    public WeatherData(String n, String m, String d, String t, String w) {
        name = n;
        main = m;
        description = d;
        temperature = t;
        windSpeed = w;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public static String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public static String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }
}
