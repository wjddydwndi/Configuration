package com.example.configuration.service;

import com.example.configuration.mapper.ConfigMapper;
import com.example.configuration.model.ConfigData;
import com.example.configuration.model.Configuration;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static com.example.configuration.commons.CommonUtils.isEmpty;

public abstract class AbstractConfigService implements ConfigService {
    private ConfigMapper configMapper;
    private Map<String, ConfigData> configurations = new ConcurrentHashMap<>(); // 최근 업데이트 데이터

    public AbstractConfigService() {
        this.configMapper = null;
    }

    @Override
    public boolean loadConfiguration() {

        List<ConfigData> updateList = getUpdateList();

        for (ConfigData data : updateList) {
            try {
                if (isEmpty(data.getUpdateTime())) continue;

                lastUpdate(data); // 전역변수 및 최근 업데이트 날짜 갱신

            } catch (Exception e) {
                // [확인 필요] 로그 추가할 것
                e.printStackTrace();
            }
        }

        return true;
    }

    private void lastUpdate(ConfigData data) {

        if (isEmpty(data) || isEmpty(data.getUpdateTime())) {
            // [확인 필요] 로그 추가할 것
            throw new NullPointerException();
        }

        String tableName = data.getTName();

        if (configurations.containsKey(tableName) == true) {
            ConfigData configData = configurations.get(tableName);

            if (configData.getUpdateTime().before(data.getUpdateTime())) {
                configurations.put(tableName, data);
                updateConfigurations(tableName);
            }

        } else {
            configurations.put(tableName, data);
            updateConfigurations(tableName);
        }
    }

    private void updateConfigurations(String tableName) {

        if (isEmpty(tableName)) {
            // [확인 필요] 로그 추가할 것
            throw new NullPointerException();
        }

        Map<String, String> param = new ConcurrentHashMap<>();
        param.put("tableName", tableName);
        configurations.get(tableName).setData(selectConfiguration(param));
    }


    private List<ConfigData> getUpdateList() {
        return configMapper.selectUpdateList();
    }

    public Map<String, ConfigData> getConfiguration() {return configurations;}

    public List<Configuration> selectConfiguration(Map<String, String> param) {
        return configMapper.selectConfiguration(param);
    }

    public void setConfigMapper(ConfigMapper configMapper) {
        this.configMapper = configMapper;
    }
}
