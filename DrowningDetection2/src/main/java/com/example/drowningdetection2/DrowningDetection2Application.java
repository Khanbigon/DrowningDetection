package com.example.drowningdetection2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.drowningdetection2.mapper")
public class DrowningDetection2Application {

	public static void main(String[] args) {
		SpringApplication.run(DrowningDetection2Application.class, args);
	}

}
