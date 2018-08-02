package com.monkey.ele.common.pojo;

public class TokenModel {

    public static final class TokenModelSetting{
        public static final long TOKEN_EXPIRES_TIME = 1;
        public static final long JWT_MAX_AGE = 3600000L;
    }

    private String userId;

    private String token;

    public TokenModel(String userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public TokenModel() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
