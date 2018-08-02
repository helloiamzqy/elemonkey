package com.monkey.ele.common.util;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.monkey.ele.common.pojo.TokenModel;

import java.util.HashMap;
import java.util.Map;

public class JWTUtils {


        private static final String SECRET = "XX#$%()(#*!()!KL<><MQLMNQNQJQK sdfkjsdrow32234545fdf>?N<:{LWPW";

        private static final String EXP = "exp";

        private static final String PAYLOAD = "payload";

        //加密，传入一个对象和有效期
        public static String sign(TokenModel tokenModel, long maxAge) {
            try {
                final JWTSigner signer = new JWTSigner(SECRET);
                final Map<String, Object> claims = new HashMap<String, Object>();
                String jsonTokenModel = JsonUtil.obj2json(tokenModel);
                claims.put(PAYLOAD, jsonTokenModel);
                claims.put(EXP, System.currentTimeMillis() + maxAge);
                return signer.sign(claims);
            } catch(Exception e) {
                return null;
            }
        }

        //解密，传入一个加密后的token字符串和解密后的类型
        public static TokenModel unsign(String jwt) {
            final JWTVerifier verifier = new JWTVerifier(SECRET);
            try {
                final Map<String,Object> claims= verifier.verify(jwt);
                if (claims.containsKey(EXP) && claims.containsKey(PAYLOAD)) {
                    long exp = (Long)claims.get(EXP);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (exp > currentTimeMillis) {
                        String json = (String)claims.get(PAYLOAD);
                        return JsonUtil.json2pojo(json,TokenModel.class);
                    }
                }
                return null;
            } catch (Exception e) {
                return null;
            }
        }


}
