package com.greenfoxacademy.levelup.utility;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

public class GenerateToken {

  private static String SECRET_KEY = "48215E15BBFBC6A43521AB86B9EE528095D287CC9433EEEFB3E288AF059CD07E";

  public static String createJWT() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String currentPrincipalName = authentication.getName();

    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    long nowMillis = System.currentTimeMillis();
    Date now = new Date(nowMillis);
    long ttlMillis = 3600000;
    long expMillis = nowMillis + ttlMillis;
    Date exp = new Date(expMillis);

    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

    JwtBuilder builder = Jwts.builder()
            .setIssuedAt(now)
            .setSubject(currentPrincipalName)
            .setIssuer("Alpine")
            .setExpiration(exp)
            .signWith(signatureAlgorithm, signingKey);

    return builder.compact();
  }
}
