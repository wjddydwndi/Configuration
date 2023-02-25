package com.example.configuration.mapper;

import com.example.configuration.model.ConfigData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigMapper {

    List<ConfigData> selectUpdateList();
    List<ConfigData> selectConfiguration();

}
