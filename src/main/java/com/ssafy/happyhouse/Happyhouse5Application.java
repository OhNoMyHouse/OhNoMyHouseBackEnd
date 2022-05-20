package com.ssafy.happyhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @MapperScan(basePackages = {"com.ssafy.happyhouse.model.dao"}, annotationClass = Mapper.class)
@SpringBootApplication
public class Happyhouse5Application {

    public static void main(String[] args) {
        SpringApplication.run(Happyhouse5Application.class, args);
    }

}