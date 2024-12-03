package com.example.TodoList;

import com.example.TodoList.service.WeatherService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TodoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}
	@Bean
	public WeatherService weatherService() {
		return new WeatherService();
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
