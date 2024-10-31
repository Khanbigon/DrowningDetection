package com.example.drowningdetection2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.drowningdetection2.mapper.SensorMapper;
import com.example.drowningdetection2.model.ResponseResult;
import com.example.drowningdetection2.model.SensorData;
import com.example.drowningdetection2.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SensorDataServiceImpl extends ServiceImpl<SensorMapper, SensorData> implements SensorDataService {

    @Autowired
    private SensorDataService sensorDataService;

    @Autowired
    private SensorMapper sensorMapper;

    public void processData(String data) {
        try {
            // Example data format: "deviceId:1,heartRate:75"
            String[] parts = data.split(",");
            String deviceId = parts[0].split(":")[1].trim();
            double heartRate = Double.parseDouble(parts[1].split(":")[1].trim());
            double LocationX = Double.parseDouble(parts[2].split(":")[1].trim());
            double LocationY = Double.parseDouble(parts[3].split(":")[1].trim());

            SensorData sensorData = new SensorData();
            sensorData.setUserId(deviceId);
            sensorData.setHeartRate(heartRate);
            sensorData.setTimestamp(new Date());
            sensorData.setAge(1);
            sensorData.setLocationX(LocationX);
            sensorData.setLocationY(LocationY);
//            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//注意月和小时的格式为两个大写字母
//            java.util.Date date = new Date();//获得当前时间
//            String str = df.format(date);//将当前时间转换成特定格式的时间字符串，这样便可以插入到数据库中
//            sensorData.setTimestamp(str);

            sensorDataService.save(sensorData);

            if (isDrowning(heartRate)) {
                System.out.println("Drowning detected for deviceId: " + deviceId);
                // Logic to handle drowning detection, e.g., send alert
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to process data: " + data);
        }
    }

    @Override
    public ResponseResult setage(Integer id, Integer age) {
        LambdaUpdateWrapper<SensorData> lambdaUpdateWrapper=new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(SensorData::getUserId, id).set(SensorData::getAge, age);
        sensorMapper.update(null, lambdaUpdateWrapper);
        return ResponseResult.okResult();
    }

    private boolean isDrowning(double heartRate) {
        // Simple logic to determine if someone is drowning based on heart rate
        // This should be replaced with a proper algorithm
        return heartRate < 50;
    }

    @Override
    public ResponseResult findAll() {
        List<SensorData> sensorDataList=new ArrayList<>();
        sensorDataList=sensorDataService.getBaseMapper().selectList(null);
        return ResponseResult.okResult(sensorDataList);
    }
}
