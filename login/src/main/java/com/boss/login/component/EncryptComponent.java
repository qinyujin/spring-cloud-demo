package com.boss.login.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author :覃玉锦
 * @create :2020-07-30 15:17:00
 */
@Component
public class EncryptComponent {
    @Value("${my.secretkey}")
    private String secretkey="assafas";

    @Value("${my.salt}")
    private String salt="484565";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TextEncryptor encryptor;

    @Bean
    public TextEncryptor getEncrypt() {
        return Encryptors.text(secretkey, salt);
    }

    public String encryptToken(MyToken myToken) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(myToken);
        } catch (JsonProcessingException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "服务器异常");
        }
        return encryptor.encrypt(json);

    }

    public MyToken decryptToken(String auth) {
        String json = encryptor.decrypt(auth);
        try {
            return objectMapper.readValue(json, MyToken.class);
        } catch (JsonProcessingException e) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "无权限");
        }
    }
}
