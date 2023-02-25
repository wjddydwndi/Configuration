package com.example.configuration.batch;

import com.example.configuration.service.ConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;

//@Scheduled(cron = "")
@RequiredArgsConstructor
public class ConfigScheduler {

    private final ConfigService configService;

    public void loadConfig() {

        try {
            configService.loadConfiguration();
        } catch(Exception e) {

        }


    }
}
