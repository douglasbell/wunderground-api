package com.dugbel.wunderground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

	/**
	 * Program entrance point
	 * 
	 * @param args	Program takes no arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}