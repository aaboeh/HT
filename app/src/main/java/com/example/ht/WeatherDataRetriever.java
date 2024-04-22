package com.example.ht;

import android.util.Log;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class WeatherDataRetriever {
    private final String API_KEY = "073fec496a1a0f51b5555dd95614300d";
    private final String CONVERTER_BASE = "http://api.openweathermap.org/geo/1.0/direct?q=%s&limit=5&appid=073fec496a1a0f51b5555dd95614300d";
    private final String WEATHER_BASE_URL = "https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s";

    public WeatherData getWeatherData(String municipality) {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode areas = null;
        try {
            areas = objectMapper.readTree(new URL(String.format(CONVERTER_BASE, municipality)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Log.d("LUT", areas.toPrettyString());

        return null;
    }
}
