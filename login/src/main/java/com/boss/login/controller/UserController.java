package com.boss.login.controller;

import com.boss.login.component.EncryptComponent;
import com.boss.login.component.MyToken;
import com.boss.login.dao.UserDao;
import com.boss.login.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :覃玉锦
 * @create :2020-07-30 16:11:00
 */
@RestController
@RequestMapping("/api/user")
@RefreshScope
@Slf4j
public class UserController {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private EncryptComponent encryptComponent;

    /**
     * 登录
     *
     * @param user
     * @param request
     * @return
     */
    @PostMapping("login")
    public Map login(@RequestBody User user, HttpServletRequest request) {
        User u = UserDao.getUser();
        if (u.getNum().equals(user.getNum())) {
            boolean matches = encoder.matches(user.getPassword(), u.getPassword());
            if (matches) {
                u.setLoginStatu(true);
                MyToken myToken = new MyToken(u.getName(), u.getUid());
                String auth = encryptComponent.encryptToken(myToken);
                request.getSession().setAttribute(MyToken.AUTHORIZATION, auth);
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "密码错误");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "账号错误");
        }

        Map map = new HashMap(16);
        map.put("name", u.getName());
        return map;
    }

    /**
     * 判断登录状态
     *
     * @return
     */
    @GetMapping("loginStatu")
    public boolean getLoginStatu() {
        User user = UserDao.getUser();
        return user.isLoginStatu();
    }
}
