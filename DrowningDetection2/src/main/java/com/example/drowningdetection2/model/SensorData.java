package com.example.drowningdetection2.model;



import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sensor")
@Accessors(chain = true)
public class SensorData {

    @TableId
    private Long id;
    private String userId;
    private double heartRate;
    private Date timestamp;
    private boolean isdrowning;
    private Integer age;
    private double locationX;
    private double locationY;
}
