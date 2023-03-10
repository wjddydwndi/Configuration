package com.example.configuration.model;


import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ConfigData {
    private int seq;
    private String tName;
    private Date updateTime;
    private List<Configuration> data;
}
