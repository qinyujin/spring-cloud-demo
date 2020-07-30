package com.boss.login.entity;

import lombok.Data;

/**
 * @author :覃玉锦
 * @create :2020-07-30 15:14:00
 */
@Data
public class User {

    private String num;
    private String name;
    private String password;
    private int uid;
    private boolean loginStatu;

}
