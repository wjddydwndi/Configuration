package com.example.configuration.config;

import com.example.configuration.mapper.ConfigMapper;
import com.example.configuration.service.ConfigService;
import com.example.configuration.service.ConfigServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanContainer {

    private final ConfigMapper configMapper;


    @Bean
    public ConfigService configService(ConfigMapper configMapper) {
        return new ConfigServiceImpl(configMapper);
    }
}
