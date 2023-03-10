package com.example.configuration.batch;

import com.example.configuration.service.ConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;

@RequiredArgsConstructor
public class ConfigScheduler {

    private final ConfigService configService;

    @Scheduled(cron = "*/30 * * * * *") // 30초마다 실행
    public void loadConfig() {

        try {
            configService.loadConfiguration();

        } catch(Exception e) {
            // [확인 필요] 로그 추가할 것
            e.printStackTrace();
        }


    }
}
