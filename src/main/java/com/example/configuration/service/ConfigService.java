package com.example.configuration.service;

import com.example.configuration.model.ConfigData;
import com.example.configuration.model.Configuration;

import java.util.List;
import java.util.Map;

public interface ConfigService {

    boolean loadConfiguration();

    Map<String, ConfigData> getConfiguration();

    List<Configuration> selectConfiguration(Map<String, String> param);
}