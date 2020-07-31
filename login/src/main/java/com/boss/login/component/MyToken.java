package com.boss.login.component;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author :覃玉锦
 * @create :2020-07-30 15:22:00
 */
@Data
@AllArgsConstructor
public class MyToken {
    public static final String AUTHORIZATION = "authorization";

    private String name;

    private int uid;
}
