package com.example.TodoList.service;

import com.example.TodoList.apiResponse.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class WeatherService {
    private static final String ApiKey="2e4f0ae668af96a5793bfa30a7f4aca9";
    private static final String Api="https://api.weatherstack.com/current?access_key=API_KEY&query=M=CITY";

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeather(String city){
        String finalAPI=Api.replace("CITY",city).replace("API_KEY",ApiKey);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;
    }

}
