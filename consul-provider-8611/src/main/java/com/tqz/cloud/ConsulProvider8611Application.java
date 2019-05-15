package com.tqz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class ConsulProvider8611Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsulProvider8611Application.class, args);
    }

    @RequestMapping("/hi")
    public String hi() {
        return "Hi from 8611";
    }

}
