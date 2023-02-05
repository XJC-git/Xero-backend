package com.xerotech.funcx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xerotech.funcx.mapper")
public class FuncXApplication {

    public static void main(String[] args) {
        SpringApplication.run(FuncXApplication.class, args);
    }

}
