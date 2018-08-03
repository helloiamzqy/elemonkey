package com.monkey.ele.common.security.service;

import org.apache.shiro.authc.SimpleAuthenticationInfo;

public interface AuthorizeUserDao {

    boolean isExists(String username);

    boolean validate(String username, String password);

    SimpleAuthenticationInfo createAuthenticationInfo(String username, String realmName);

}
