package com.example.configuration.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Configuration
@Import(DatabaseConfig.class)
@ComponentScan(
        useDefaultFilters = false,
        basePackages = "com.example.configuration",
        includeFilters = {
                @ComponentScan.Filter(value = Service.class, type = FilterType.ANNOTATION),
                @ComponentScan.Filter(value = Configuration.class, type = FilterType.ANNOTATION),
                @ComponentScan.Filter(value = Component.class, type = FilterType.ANNOTATION),
                @ComponentScan.Filter(value = Scheduled.class, type = FilterType.ANNOTATION)

        }
)
public class TestConfiguration {
}
