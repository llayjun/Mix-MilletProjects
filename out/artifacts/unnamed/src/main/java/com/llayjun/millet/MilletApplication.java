package com.llayjun.millet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author yinleizhang
 */
@SpringBootApplication
@EnableCaching
@EnableAsync
@MapperScan("com.llayjun.millet.module.**.mapper")//使用MapperScan批量扫描所有的Mapper接口；
@EnableScheduling
public class MilletApplication {

    public static void main(String[] args) {
        SpringApplication.run(MilletApplication.class, args);
    }

}
