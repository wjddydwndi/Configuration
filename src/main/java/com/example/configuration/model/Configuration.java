package com.example.configuration.model;

import lombok.Data;

import java.util.Date;

@Data
public class Configuration {

    private int seq;
    private String category;
    private String code;
    private String value;
    private String decription;
    private boolean isEnable;
    private Date updateTime;
    private Date createTime;
}
