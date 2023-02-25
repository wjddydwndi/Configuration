package com.example.configuration.service;

import com.example.configuration.mapper.ConfigMapper;
import com.example.configuration.model.ConfigData;
import com.example.configuration.model.Configuration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.configuration.commons.CommonUtils.isEmpty;

@Service
public class ConfigServiceImpl extends AbstractConfigService {

    public ConfigServiceImpl(ConfigMapper configMapper) {
        super(configMapper);
    }


    @Override
    public boolean loadConfiguration() {
        return false;
    }

    @Override
    public List<Configuration> getConfiguration() {

        return super.getConfiguration();
    }

}
