package com.everydayBanking.everydayBank.securityconfig;

import com.everydayBanking.everydayBank.model.CustomerPrincipal;
import com.everydayBanking.everydayBank.service.CustomerUserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.xml.crypto.Data;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtils {

    @Value("${spring.app.jwtSecret}")
    private String key;

    @Value("${spring.app.expirationTime}")
    private int expiration;
//    utility methods
//    generateTokenFromUsername
//    generateUsernameFromJwtToken
//    verifyJwtToken
    public String generateJwtToken(String username ){

//        Create HashMap to hold claims;
        Map<String, Object> claims = new HashMap<>();
//        Using jwt builder
        return Jwts.builder()
//                claims
                .claims()
                .add(claims)
//                set username
                .subject(username)
//                date issued
                .issuedAt(new Date(System.currentTimeMillis()))
//                expiration date
                .expiration(new Date(System.currentTimeMillis()+ 60*60*30))
                .and()
                .signWith(getKey())
                .compact();

    }

//    This method returns the key for signing the JWT
    private Key getKey() {
//        First we need to convert the secret key into byte which the Keys class would need to convert the string into keys,
//        so I need the Decoders class.
        byte[] keyBytes = Decoders.BASE64.decode(key);
        return Keys.hmacShaKeyFor(keyBytes) ;
    }

    public String getUsernameFromToken(String token){
        return Jwts.parser()
                .verifyWith((SecretKey) getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();

    }

    public boolean validateToken(String token){
        try {
            Jwts.parser()
                    .verifyWith((SecretKey) getKey())
                    .build()
                    .parse(token);
            return true;
        } catch (MalformedJwtException e){
            e.getMessage();
        } catch (ExpiredJwtException e){
            e.getMessage();
        }
        return false;
    }
}


