package com.boss.order.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author :覃玉锦
 * @create :2020-07-30 17:40:00
 */
@FeignClient(value = "login-service")
public interface LoginConsumerClient {
    /**
     * 使用feign调用login-service的服务
     *
     * @return
     */
    @GetMapping("/api/loginStatu")
    boolean getLoginStatu();
}
