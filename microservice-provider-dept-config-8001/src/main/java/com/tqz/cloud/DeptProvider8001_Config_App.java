package com.tqz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

// 开启 eureka client 端注解，将本 provider 服务注册进  eureka 中
@EnableEurekaClient
@SpringBootApplication
public class DeptProvider8001_Config_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001_Config_App.class, args);
    }
}
