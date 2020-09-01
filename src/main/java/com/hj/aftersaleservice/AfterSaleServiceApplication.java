package com.hj.aftersaleservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.hj.aftersaleservice.dao")
@SpringBootApplication
public class AfterSaleServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AfterSaleServiceApplication.class, args);
    }

}
