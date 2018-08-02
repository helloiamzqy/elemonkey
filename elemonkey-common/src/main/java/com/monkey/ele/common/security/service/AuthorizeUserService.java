package com.monkey.ele.common.security.service;

public interface AuthorizeUserService {

    boolean isExists(String username);

    boolean validate(String username, String password);

}
