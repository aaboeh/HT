package com.example.ht;

import android.util.Log;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class WeatherDataRetriever {
    private final String API_KEY = "073fec496a1a0f51b5555dd95614300d";
    private final String CONVERTER_BASE = "https://api.openweathermap.org/geo/1.0/direct?q=%s&limit=5&appid=073fec496a1a0f51b5555dd95614300d";
    private final String WEATHER_BASE_URL = "https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s";

    public WeatherData getWeatherData(String municipality) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode areas = null;
            try {
                areas = objectMapper.readTree(new URL(String.format(CONVERTER_BASE, municipality)));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Log.d("LUT", areas.toPrettyString());

            String latitude = areas.get(0).get("lat").toString();
            String longitude = areas.get(0).get("lon").toString();

            JsonNode weatherData;

            try {
                weatherData = objectMapper.readTree(new URL(String.format(WEATHER_BASE_URL, latitude, longitude, API_KEY)));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Log.d("LUT", weatherData.toPrettyString());

            WeatherData wd = new WeatherData(
                    weatherData.get("name").asText(),
                    weatherData.get("weather").get(0).get("main").asText(),
                    weatherData.get("weather").get(0).get("description").asText(),
                    weatherData.get("main").get("temp").asText(),
                    weatherData.get("wind").get("speed").asText()
            );

            return wd;
        } catch (Exception e) {

        }
        return null;
    }
}
