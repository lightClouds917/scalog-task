package com.java4all.scalogtask;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangzhongxiang
 */
@SpringBootApplication
@MapperScan("com.java4all.scalogtask.dao")
public class ScalogTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScalogTaskApplication.class, args);
    }
}
