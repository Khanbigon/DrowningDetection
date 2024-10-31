package com.example.drowningdetection2.controller;

import com.example.drowningdetection2.model.Dto.AgeDto;
import com.example.drowningdetection2.model.ResponseResult;
import com.example.drowningdetection2.model.SensorData;
import com.example.drowningdetection2.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class SensorDataController {

    @Autowired
    private SensorDataService sensorDataService;

    @GetMapping("/data")
    public ResponseResult getAllData() {
        return sensorDataService.findAll();
    }

    @PostMapping("/setage")
    public ResponseResult setAge(@RequestBody AgeDto ageDto) {
        return sensorDataService.setage(ageDto.getUserID(),ageDto.getAge());
    }





}
