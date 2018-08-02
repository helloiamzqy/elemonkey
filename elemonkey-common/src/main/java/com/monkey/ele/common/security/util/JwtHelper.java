package com.monkey.ele.common.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/2/2018 1:38 PM
 **/
@Component
public class JwtHelper {

    /**
     * JWT Token Expire Time (1h)
     */
    public static final Integer TOKEN_EXPIRE_TIME = 60 * 60;

    /**
     * JWT Key
     */
    private static Key key;

    static {
        key = MacProvider.generateKey();
    }

    public String sign (Map claims) {
        return Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + (this.TOKEN_EXPIRE_TIME * 1000)))
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }

    public boolean verify (String token, Map claims) {
        if (token == null || token.trim().isEmpty())
            return false;
        Claims body = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        if (body.getExpiration().before(new Date()))
            return false;
        return body.equals(claims);
    }

    String getUsername (String token) {
        if (token == null || token.trim().isEmpty())
            return null;
        Claims body = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        if (body == null || body.getExpiration().before(new Date())) {
            return null;
        }
        return body.get("username").toString();
    }

    String getId (String token) {
        if (token == null || token.trim().isEmpty())
            return null;
        Claims body = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        if (body == null || body.getExpiration().before(new Date())) {
            return null;
        }
        return body.get("id").toString();
    }

}
