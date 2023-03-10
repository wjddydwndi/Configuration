package com.example.configuration.service;

import com.example.configuration.mapper.ConfigMapper;
import com.example.configuration.model.ConfigData;
import com.example.configuration.model.Configuration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

import static com.example.configuration.commons.CommonUtils.isEmpty;

@Service
@RequiredArgsConstructor
public class ConfigServiceImpl extends AbstractConfigService {
    private final ConfigMapper configMapper;

    @PostConstruct
    public void initialize() {
        setConfigMapper(configMapper);
    }

    @Override
    public boolean loadConfiguration() {return super.loadConfiguration();}

    @Override
    public Map<String, ConfigData> getConfiguration() {return super.getConfiguration();}

}
