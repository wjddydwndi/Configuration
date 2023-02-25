package com.example.configuration.service;

import com.example.configuration.model.ConfigData;
import com.example.configuration.model.Configuration;

import java.util.List;

public interface ConfigService {

    boolean loadConfiguration();
    List<Configuration> getConfiguration();
}
