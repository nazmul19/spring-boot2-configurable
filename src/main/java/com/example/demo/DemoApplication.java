package com.example.demo;

import com.example.demo.service.FakeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@EnableSpringConfigured
@EnableLoadTimeWeaving
@SpringBootApplication

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Configuration
	@EnableSpringConfigured
	public static class FakeServiceConfiguration {
		@Bean
		public FakeService fakeService() {
			return new FakeService();
		}
	}
}
