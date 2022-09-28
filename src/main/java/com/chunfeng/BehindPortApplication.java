package com.chunfeng;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
@MapperScan("com.chunfeng.dao.mapper")
public class BehindPortApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(BehindPortApplication.class, args);
        log.info("主启动类准备就绪!" + run);
    }

}
