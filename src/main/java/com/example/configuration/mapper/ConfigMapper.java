package com.example.configuration.mapper;

import com.example.configuration.model.ConfigData;
import com.example.configuration.model.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ConfigMapper {

    List<ConfigData> selectUpdateList();
    List<Configuration> selectConfiguration(Map<String, String> param);
}
