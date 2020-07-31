package com.boss.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author :覃玉锦
 * @create :2020-07-30 17:59:00
 */
@Data
@AllArgsConstructor
public class Item {
    private String name;

    private int price;
}
