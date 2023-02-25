package com.example.configuration.service;

import com.example.configuration.mapper.ConfigMapper;
import com.example.configuration.model.ConfigData;
import com.example.configuration.model.Configuration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.example.configuration.commons.CommonUtils.isEmpty;

@Component
@RequiredArgsConstructor
public abstract class AbstractConfigService implements ConfigService{
    private final ConfigMapper configMapper;
    private Map<String, ConfigData> configDatas = new ConcurrentHashMap<>();
    private List<Configuration> configurations = new ArrayList<>();

    @Override
    public boolean loadConfiguration() {
        // 1. 업데이트 내역이 있는지 확인
        if (isEmpty(configDatas)) {
            return updateAll();
        }

        List<ConfigData> updateList = getUpdateList();
        if (isEmpty(updateList)) {
            return true;
        }
        // 2-1. 업데이트 내역이 없으면 return
        // 2-2. 업데이트 내역이 있으면 업데이트
        return update(updateList);
    }


    private List<ConfigData> getUpdateList() {
        return configMapper.selectUpdateList();
    }


    private boolean update(List<ConfigData> list) {

        if (isEmpty(list)) {
            // [확인 필요] 로그 추가할 것
            throw new NullPointerException("업데이트할 항목 없음.");
        }

        try {

            for (ConfigData item : list) {
                String tName = item.getTName();
                Date lastUpdateTime = item.getUpdateTime();

                ConfigData prev = configDatas.get(tName);
                Date prevUpdateTime = prev.getUpdateTime();

                if (lastUpdateTime.before(prevUpdateTime)) {
                    updateByTable(tName);
                }
            }


        } catch (Exception e) {

        }

        return true;
    }


    private void updateByTable(String tName) {

        if (isEmpty(tName)) {
            throw new NullPointerException();
        }

        switch (tName) {
            case "t_configuration" :
        }
    }


    public boolean updateAll() {
        //configurations = configMapper.getConfigurations();
        return true;
    }

    public List<Configuration> getConfiguration() {return configurations;}


}
