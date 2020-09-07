package com.paperx.bgbackup.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @desc   使用token验证用户是否登录
 * @author dky
 **/
public class TokenUtils {
    //设置过期时间 30*60*
    private static final long EXPIRE_DATE=10000;
    //token秘钥
    private static final String TOKEN_SECRET = "ZCfasfhuaUUdugewudi12020BQWE";

    public static String token (String username,String userId){

        String token = "";
        try {
            //过期时间
            Date date = new Date(System.currentTimeMillis()+EXPIRE_DATE);
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String,Object> header = new HashMap<>();
            header.put("typ","JWT");
            header.put("alg","HS256");
            //携带username，password信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("username",username)
                    .withClaim("userId",userId).withExpiresAt(date)
                    .sign(algorithm);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
        return token;
    }

    public static boolean verify(String token){
        /**
         * @desc   验证token，通过返回true
         * @params [token]需要校验的串
         **/
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }
    public static void main(String[] args) {
        String username ="zhangsan";
        String userId = "123";
        String token = token(username,userId);
        System.out.println(token);
        String tk = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJwYXNzd29yZCI6IjEyMyIsImV4cCI6MTU5ODk3NDE1NSwidXNlcm5hbWUiOiJ6aGFuZ3NhbiJ9.Ea1typqVeisnmZRq8uJ0lCGj3cTBepH5rpSYrV-R_eY";
        boolean b = verify(tk);
        System.out.println(b);
    }
}
