package com.boss.login;

import com.boss.login.component.EncryptComponent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
@Slf4j
class LoginApplicationTests {
    @Autowired
   private EncryptComponent encryptComponent;
    @Autowired
    private PasswordEncoder encoder;

    @Test
    void tst1(){
        //$2a$10$AxeRnBuUHrxiwsYR47P6t.m9mm/kt8R0S1DeNB1bDxkXz5OehSs.i
       log.debug("{}", "AMD yes");
    }

}
