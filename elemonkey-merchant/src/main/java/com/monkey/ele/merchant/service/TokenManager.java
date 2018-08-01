package com.monkey.ele.merchant.service;

import com.monkey.ele.common.pojo.TokenModel;

public interface TokenManager {

    public TokenModel createToken(String userId);

    public boolean checkToken(TokenModel tokenModel);


}
