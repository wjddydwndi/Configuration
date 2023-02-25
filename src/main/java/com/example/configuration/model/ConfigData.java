package com.example.configuration.model;


import lombok.Data;

import java.util.Date;

@Data
public class ConfigData {
    private int seq;
    private String tName;
    private Date updateTime;
    private Object data;
}
