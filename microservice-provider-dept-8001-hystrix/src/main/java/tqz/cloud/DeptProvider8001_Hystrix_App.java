package tqz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableCircuitBreaker//对hystrixR熔断机制的支持
@EnableEurekaClient// 开启 eureka client 端注解，将本 provider 服务注册进  eureka 中
@SpringBootApplication
public class DeptProvider8001_Hystrix_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001_Hystrix_App.class, args);
    }
}
