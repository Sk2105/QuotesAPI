package com.sk.quotesapi.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

import org.springframework.stereotype.Component;


@Component
public class JwtService {

    private String secretKey = "sk2105";

    public String generateToken(String username) {
        try {
            return JWT.create()
                    .withClaim("username", username)
                    .withIssuedAt(new Date())
                    .sign(Algorithm.HMAC256(secretKey));
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
    }

    public boolean validateToken(String token) {
        try {
            JWT.require(Algorithm.HMAC256(secretKey)).build().verify(token);
            return true;
        } catch (Exception e) {
            System.out.println(e);
           return false;
        }
    }

    public String extractUsername(String token) {
        try {
            return JWT.require(Algorithm.HMAC256(secretKey)).ignoreIssuedAt().build().verify(token).getClaim("username")
                    .asString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
