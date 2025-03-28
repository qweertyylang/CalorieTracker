package com.calorietracker;

import com.calorietracker.component.propertie.RsaProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaProperties.class)
public class CalorieTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalorieTrackerApplication.class, args);
    }

}
