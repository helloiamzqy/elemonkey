package com.monkey.ele.customer.service.impl;

import com.monkey.ele.common.pojo.TokenModel;
import com.monkey.ele.common.util.UUIDUtils;
import com.monkey.ele.customer.service.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TokenManagerImpl implements TokenManager {

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public TokenModel createToken(String userId) {
        String token = UUIDUtils.getUUID();
        TokenModel tokenModel = new TokenModel(userId,token);
        redisTemplate.boundValueOps(token).set(userId,TokenModel.TokenModelSetting.TOKEN_EXPIRES_TIME,TimeUnit.HOURS);
        return tokenModel;
    }

    @Override
    public boolean checkToken(TokenModel tokenModel) {
        return false;
    }

    @Override
    public TokenModel parseToken(String encryptStr) {
        return null;
    }

    @Override
    public boolean deleteToken(TokenModel tokenModel) {
        return false;
    }
}
