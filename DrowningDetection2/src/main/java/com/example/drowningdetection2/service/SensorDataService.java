package com.example.drowningdetection2.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.drowningdetection2.model.ResponseResult;
import com.example.drowningdetection2.model.SensorData;

import java.util.List;

public interface SensorDataService extends IService<SensorData> {
    ResponseResult findAll();

    void processData(String data);

    ResponseResult setage(Integer id, Integer age);
}
