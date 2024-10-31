package com.example.drowningdetection2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.drowningdetection2.model.ResponseResult;
import com.example.drowningdetection2.model.SensorData;
import com.example.drowningdetection2.service.SensorDataService;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SensorMapper extends BaseMapper<SensorData> {

}
