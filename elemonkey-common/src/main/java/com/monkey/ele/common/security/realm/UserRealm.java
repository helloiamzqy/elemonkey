package com.monkey.ele.common.security.realm;

import com.monkey.ele.common.security.service.AuthorizeUserDao;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/2/2018 10:28 AM
 **/
@Component
public class UserRealm extends AuthorizingRealm {

    private static final Logger LOGGER = Logger.getLogger(UserRealm.class);

    @Autowired
    private AuthorizeUserDao userDao;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public String getName() {
        return this.userDao.getClass().getName().toUpperCase() + "_USER_REALM";
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * User Login
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        if (!this.userDao.isExists(token.getUsername())) {
            LOGGER.info("user not exists, username: " + token.getUsername());
            return null;
        }

        if (!this.userDao.validate(token.getUsername(), new String(token.getPassword()))) {
            LOGGER.info("wrong user password, username: " + token.getUsername());
            return null;
        }

        return this.userDao.createAuthenticationInfo(token.getUsername(), getName());
    }

}
