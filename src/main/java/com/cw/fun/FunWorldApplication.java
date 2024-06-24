package com.cw.fun;

import com.dtflys.forest.springboot.annotation.ForestScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ForestScan(basePackages = "com.cw.fun.forest")
public class FunWorldApplication {
    public static void main(String[] args) {
        SpringApplication.run(FunWorldApplication.class, args);
    }
}
