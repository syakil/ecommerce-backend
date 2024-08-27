package com.belajar.ecommerce.security.jwt;

import com.belajar.ecommerce.security.services.UserDetailsImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${jwt.expirationMs}")
    private int jwtExpirationMs;
    @Value("${jwt.secret}")
    private String jwtSecret;

    public boolean validateJwtToken(String authToken) {
        try{
            Jwts.parser().setSigningKey(jwtSecret).build().parseClaimsJws(authToken);
            return true;
        }catch (SignatureException e){
            System.out.println("Invalid JWT signature: " + e.getMessage());
            logger.error("Invalid JWT signature: {}", e.getMessage());
        }catch (MalformedJwtException e){
            System.out.println("Invalid JWT token: " + e.getMessage());
            logger.error("Invalid JWT token: {}", e.getMessage());
        }catch (ExpiredJwtException e){
            System.out.println("JWT token is expired: " + e.getMessage());
            logger.error("JWT token is expired: {}", e.getMessage());
        }catch (UnsupportedJwtException e) {
            System.out.println("JWT token is unsupported: " + e.getMessage());
            logger.error("JWT token is unsupported: {}", e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println("JWT claims string is empty: " + e.getMessage());
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }

    public String generateJwtToken(Authentication authentication){
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new java.util.Date())
                .setExpiration(new java.util.Date((new java.util.Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.ES512, jwtSecret)
                .compact();
    }

    public String getUserNameFromJwtToken(String token){
        return Jwts.parser().setSigningKey(jwtSecret).build().parseClaimsJws(token).getBody().getSubject();
    }
}
