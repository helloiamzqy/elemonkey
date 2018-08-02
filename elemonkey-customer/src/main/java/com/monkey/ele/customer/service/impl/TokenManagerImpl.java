package com.monkey.ele.customer.service.impl;

import com.monkey.ele.common.pojo.TokenModel;
import com.monkey.ele.common.util.JWTUtils;
import com.monkey.ele.common.util.UUIDUtils;
import com.monkey.ele.customer.service.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
        String redis_userId  = (String) redisTemplate.boundValueOps(tokenModel.getToken()).get();
        if(redis_userId!=null&&redis_userId.equals(tokenModel.getUserId())){
            redisTemplate.boundValueOps(tokenModel.getToken()).set(redis_userId,TokenModel.TokenModelSetting.TOKEN_EXPIRES_TIME,TimeUnit.HOURS);
            return true;
        }
        return false;
    }

    @Override
    public TokenModel parseToken(String JWTString) {
        if (StringUtils.isEmpty(JWTString)){
            return null;
        }
        TokenModel tml = JWTUtils.unsign(JWTString);
        return tml;
    }

    @Override
    public boolean deleteToken(TokenModel tokenModel) {
        redisTemplate.delete(tokenModel.getToken());
        return true;
    }
}
