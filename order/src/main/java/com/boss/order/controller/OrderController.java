package com.boss.order.controller;

import com.boss.order.dao.ItemDao;
import com.boss.order.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author :覃玉锦
 * @create :2020-07-30 17:20:00
 * 如果没有判断登录，不能展示页面
 */
@RestController
@RequestMapping("/api/order/")
public class OrderController {
    @Autowired
    private LoginConsumerClient consumer;

    @GetMapping("loginStatu")
    public String judgeLoginStatu(HttpServletRequest request) {
        boolean loginStatu = consumer.getLoginStatu();
        System.out.println(loginStatu);
        if(loginStatu){
            ItemDao.isLogin=true;
            return "已经登录";
        }
        else {
            return "未登录";
        }
    }

    @GetMapping("showItems")
    public List<Item> shwoItems(){
        List<Item> itemList = ItemDao.getItemList();
        if(!ItemDao.isLogin){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"未登录");
        }
        else {
            return itemList;
        }
    }

}
