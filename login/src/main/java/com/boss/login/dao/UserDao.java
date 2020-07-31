package com.boss.login.dao;

import com.boss.login.entity.User;

/**
 * @author :覃玉锦
 * @create :2020-07-30 15:50:00
 */
public class UserDao {
    private UserDao() {
    }

    private static User user = initUser();

    public static User initUser() {
        user = new User();
        user.setUid(1);
        user.setName("张三");
        user.setNum("001");
        user.setPassword("$2a$10$AxeRnBuUHrxiwsYR47P6t.m9mm/kt8R0S1DeNB1bDxkXz5OehSs.i");
        user.setLoginStatu(false);
        return user;
    }

    public static User getUser() {
        return user;
    }

}
