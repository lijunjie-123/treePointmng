package com.alibaba.workFlow;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by wangxy on 21/10/16.
 */
@SpringBootApplication
@MapperScan("com.alibaba.workFlow") //mybatis在SpringBoot启动的时候自动扫描mybatis实现的接口
public class WorkFlowApplication {
    public static void main(String[] args) {
        SpringApplication.run(WorkFlowApplication.class,args);
    }
}
