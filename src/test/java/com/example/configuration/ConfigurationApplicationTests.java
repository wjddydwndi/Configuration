package com.example.configuration;

import com.example.configuration.config.TestConfiguration;
import com.example.configuration.service.ConfigService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest(classes = TestConfiguration.class)
class ConfigurationApplicationTests {

    @Autowired
    ConfigService configService;

    @Test
    void loadConfiguration() {
        boolean success = configService.loadConfiguration();
        Assertions.assertEquals(true, success);
    }

}
