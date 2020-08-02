package com.boss.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author :覃玉锦
 * @create :2020-08-02 13:04:00
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudGatewayApplication.class, args);
    }
}
